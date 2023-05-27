package ru.otus.jdbc.mapper;

import ru.otus.crm.model.Id;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class EntityClassMetaDataImpl<T> implements EntityClassMetaData<T> {
    private final Class<T> persistentClass;
    private final List<Field> allFieldsListMetaData;
    private List<Field> declaredFields;

    public EntityClassMetaDataImpl(Class<T> tClass) {
        persistentClass = tClass;
        allFieldsListMetaData = getAllFields();
    }

    @Override
    public String getName() {
        return persistentClass.getSimpleName();
    }

    @Override
    public Constructor<T> getConstructor() {
        var con = persistentClass.getDeclaredConstructors();
        for (Constructor<?> constructor : con) {
            if (constructor.getParameterCount() == allFieldsListMetaData.size())
                return (Constructor<T>) constructor;
        }
        throw new RuntimeException("");
    }

    @Override
    public Field getIdField() {
        for (Field x : allFieldsListMetaData
        ) {
            if (x.isAnnotationPresent(Id.class)) {
                return x;
            }
        }
        throw new RuntimeException("");
    }

    @Override
    public List<Field> getAllFields() {
        if (declaredFields == null) {
            declaredFields = List.of(persistentClass.getDeclaredFields());
        }
        return declaredFields;
    }

    @Override
    public List<Field> getFieldsWithoutId() {
        List<Field> result = new ArrayList<>();
        for (Field x : allFieldsListMetaData) {
            if (!(x.isAnnotationPresent(Id.class))) {
                result.add(x);
            }
        }
        return result;
    }
}
