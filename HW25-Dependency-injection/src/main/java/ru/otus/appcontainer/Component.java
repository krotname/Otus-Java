package ru.otus.appcontainer;

import java.util.Arrays;
import java.util.List;

public class Component {

    private static long count;
    private final long id;
    private final Object obj;
    private final String name;
    private final Class<?>[] interfaces;

    public Component(Object obj, String name, Class<?>[] interfaces) {
        id = count++;
        this.obj = obj;
        this.name = name;
        this.interfaces = interfaces;
    }

    public static long getCount() {
        return count;
    }

    public long getId() {
        return id;
    }

    public Object getObj() {
        return obj;
    }

    public String getName() {
        return name;
    }

    public Class<?>[] getInterfaces() {
        return interfaces;
    }

    @Override
    public String toString() {
        return "Component{" +
                "id=" + id +
                ", obj=" + obj +
                ", name='" + name + '\'' +
                ", interfaces=" + Arrays.toString(interfaces) +
                '}';
    }
}
