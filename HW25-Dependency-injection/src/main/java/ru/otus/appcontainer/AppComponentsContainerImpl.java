package ru.otus.appcontainer;

import ru.otus.appcontainer.api.AppComponent;
import ru.otus.appcontainer.api.AppComponentsContainer;
import ru.otus.appcontainer.api.AppComponentsContainerConfig;
import ru.otus.config.AppConfig;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.*;
import java.util.stream.Collectors;

public class AppComponentsContainerImpl implements AppComponentsContainer {

    private static final Class<AppComponent> ANNOTATION_CLASS = AppComponent.class;
    private final List<Component> appComponents = new ArrayList<>();

    public AppComponentsContainerImpl(Class<?> initialConfigClass) {
        processConfig(initialConfigClass);
    }

    private void processConfig(Class<?> configClass) {
        try {
            checkConfigClass(configClass);

            Object instance = createConfigInstance(configClass);

            List<Method> annotatedMethods = Arrays.stream(configClass.getDeclaredMethods())
                    .filter(m -> m.isAnnotationPresent(ANNOTATION_CLASS))
                    .sorted(Comparator.comparingInt(m -> m.getAnnotation(ANNOTATION_CLASS).order()))
                    .toList();

            for (Method method : annotatedMethods) {
                Parameter[] parameters = method.getParameters();
                Object[] args = new Object[parameters.length];

                for (int i = 0; i < parameters.length; i++) {
                    Class<?> type = parameters[i].getType();
                    args[i] = getAppComponentByType(type);
                }

                Object component = method.invoke(instance, args);
                appComponents.add(new Component(component, method.getAnnotation(ANNOTATION_CLASS).name(), component.getClass().getInterfaces()));
            }
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException(e);
        }
    }

    // Метод для создания экземпляра класса конфигурации
    private Object createConfigInstance(Class<?> configClass) throws InstantiationException, IllegalAccessException, InvocationTargetException {
        return configClass.getDeclaredConstructors()[0].newInstance();
    }

    private Object getAppComponentByType(Class<?> type) {
        return appComponents.stream()
                .filter(c -> Arrays.asList(c.getInterfaces()).contains(type))
                .findFirst()
                .orElseThrow()
                .getObj();
    }


    private void checkConfigClass(Class<?> configClass) {
        if (!configClass.isAnnotationPresent(AppComponentsContainerConfig.class)) {
            throw new IllegalArgumentException(String.format("Given class is not config %s", configClass.getName()));
        }
    }

    @Override
    public <C> C getAppComponent(Class<C> componentClass) {
        return (C) appComponents.stream()
                .filter(component -> component
                        .getObj()
                        .getClass()
                        .equals(componentClass) ||
                        Arrays.stream(component.getInterfaces())
                                .anyMatch(a -> a.equals(componentClass)))
                .findFirst()
                .orElseThrow()
                .getObj();
    }

    @Override
    public <C> C getAppComponent(String componentName) {
        return (C) appComponents.stream()
                .filter(component -> component.getName()
                        .equals(componentName))
                .findFirst()
                .orElseThrow()
                .getObj();
    }
}
