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

    private final List<Object> appComponents = new ArrayList<>();
    private final Map<String, Object> appComponentsByName = new LinkedHashMap<>();
    private final Map<String, Object> appComponentsByClass = new LinkedHashMap<>();

    public AppComponentsContainerImpl(Class<?> initialConfigClass) {
        processConfig(initialConfigClass);
    }

    private void processConfig(Class<?> configClass) {
        try {
            Object instance = Arrays.stream(configClass.getConstructors()).findFirst().orElseThrow().newInstance();

            Class<?>[] interfaces = configClass.getInterfaces();

            // Храним методы и их аннотации
            List<Method> annotatedMethods = new ArrayList<>();

            for (Class<?> intf : interfaces) {
                // Получаем методы интерфейса
                Method[] methods = intf.getDeclaredMethods();

                for (Method method : methods) {
                    if (method.isAnnotationPresent(AppComponent.class)) {
                        annotatedMethods.add(method);
                    }
                }
            }

            checkConfigClass(configClass);
            Map<String, Method> appComponentMethods = Arrays.stream(AppConfig.class.getDeclaredMethods())
                    .filter(m -> m.isAnnotationPresent(AppComponent.class))
                    .sorted(Comparator.comparingInt(m -> m.getAnnotation(AppComponent.class).order()))
                    .peek(o -> System.out.println(o.getName() + o.getAnnotation(AppComponent.class).order()))
                    .collect(Collectors.toMap(k -> k.getAnnotation(AppComponent.class).name(), v -> v,
                            (o1, o2) -> o1, LinkedHashMap::new));

            for (Map.Entry<String, Method> stringMethodEntry : appComponentMethods.entrySet()) {
                Object component;
                Parameter[] parameters = stringMethodEntry.getValue().getParameters();
                Object[] args = new Object[parameters.length];
                for (int i = 0; i < parameters.length; i++) {
                    Class<?> type = parameters[i].getType();
                    args[i] = appComponentsByClass.get(type.getName()); // todo здесь запрашивается интерфейс. нужно сделать чтобы хранились все интерфейсы
                    // Если args[i] остается null, возможно, потребуется создать экземпляр объекта напрямую
                    // или бросить исключение, если для этого типа нет значений по умолчанию.
                }
                component = stringMethodEntry.getValue().invoke(instance, args);
                if (component != null) {
                    appComponentsByName.put(stringMethodEntry.getKey(), component);
                    appComponentsByClass.put(component.getClass().getName(), component); // todo здесь кладется класс
                    appComponents.add(component);
                }
            }
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException(e);
        }


        System.out.println(appComponents);
        System.out.println(appComponentsByName);
        System.out.println(appComponentsByClass);
    }


    private void checkConfigClass(Class<?> configClass) {
        if (!configClass.isAnnotationPresent(AppComponentsContainerConfig.class)) {
            throw new IllegalArgumentException(String.format("Given class is not config %s", configClass.getName()));
        }
    }

    @Override
    public <C> C getAppComponent(Class<C> componentClass) {
        return (C) appComponentsByClass.get(componentClass);
    }

    @Override
    public <C> C getAppComponent(String componentName) {
        return (C) appComponentsByName.get(componentName);
    }
}
