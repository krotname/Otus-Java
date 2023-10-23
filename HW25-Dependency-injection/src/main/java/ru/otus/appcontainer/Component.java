package ru.otus.appcontainer;

import java.util.Arrays;
import java.util.List;

public class Component {

    private static long count;
    private long id;
    private Object obj;
    private String name;
    private Class<?>[] interfaces;

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

    public void setId(long id) {
        this.id = id;
    }

    public Object getObj() {
        return obj;
    }

    public void setObj(Object obj) {
        this.obj = obj;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Class<?>[] getInterfaces() {
        return interfaces;
    }

    public void setInterfaces(Class<?>[] interfaces) {
        this.interfaces = interfaces;
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
