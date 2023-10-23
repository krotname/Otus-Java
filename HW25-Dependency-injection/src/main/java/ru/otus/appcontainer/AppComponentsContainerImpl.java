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
            Object instance = Arrays.stream(configClass.getConstructors()).findFirst().orElseThrow().newInstance();

            Map<String, Method> appComponentMethods = Arrays.stream(AppConfig.class.getDeclaredMethods())
                    .filter(m -> m.isAnnotationPresent(ANNOTATION_CLASS))
                    .sorted(Comparator.comparingInt(m -> m.getAnnotation(ANNOTATION_CLASS).order()))
                    .peek(o -> System.out.println(o.getName() + o.getAnnotation(ANNOTATION_CLASS).order()))
                    .collect(Collectors.toMap(k -> k.getAnnotation(ANNOTATION_CLASS).name(), v -> v,
                            (o1, o2) -> o1, LinkedHashMap::new));

            for (Map.Entry<String, Method> stringMethodEntry : appComponentMethods.entrySet()) {
                Object component;
                Parameter[] parameters = stringMethodEntry.getValue().getParameters();
                Object[] args = new Object[parameters.length];
                for (int i = 0; i < parameters.length; i++) {
                    Class<?> type = parameters[i].getType();
                    System.out.println("type = " + type);
                    args[i] = appComponents.stream()
                            .filter(c -> Arrays.asList(c.getInterfaces()).contains(type)).findFirst().orElseThrow().getObj();
                }
                component = stringMethodEntry.getValue().invoke(instance, args);
                if (component != null) {
                    appComponents.add(new Component(component, stringMethodEntry.getKey(), component.getClass().getInterfaces()));
                }
            }
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException(e);
        }


        System.out.println("++");
        System.out.println(appComponents);
        System.out.println("++");
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
