package ru.otus.jdbc.mapper;

import java.lang.reflect.Field;
import java.util.List;

public class EntitySQLMetaDataImpl<T> implements EntitySQLMetaData<T> {

    private final EntityClassMetaData<T> entityClassMetaData;
    private final String entityClassName;
    private final String idFieldName;
    private final List<Field> fieldListWithoutId;

    public EntitySQLMetaDataImpl(EntityClassMetaData<T> entityClassMetaData) {
        this.entityClassMetaData = entityClassMetaData;
        this.entityClassName = entityClassMetaData.getName();
        this.idFieldName = entityClassMetaData.getIdField().getName();
        this.fieldListWithoutId = entityClassMetaData.getFieldsWithoutId();
    }

    @Override
    public String getSelectAllSql() {
        return "select * from " + entityClassName;
    }

    @Override
    public String getSelectByIdSql() {
        StringBuilder fields = new StringBuilder();
        for (Field field : fieldListWithoutId) {
            fields.append(", ");
            fields.append(field.getName());
        }
        return "select " + idFieldName + " " + fields + " from " + entityClassName + " where " + idFieldName + "  = ?";
    }

    @Override
    public String getInsertSql() {
        return "insert into " + entityClassName + " (" + fieldListWithoutId.get(0).getName() + ") values (?)";
    }

    @Override
    public String getUpdateSql() {
        StringBuilder fields = new StringBuilder();
        for (Field field : fieldListWithoutId) {
            fields.append(" set ");
            fields.append(field.getName());
            fields.append(" = ?");
            fields.append(", ");
        }
        return "update " + entityClassName + fields.substring(0, fields.length() - 2) + " where " + idFieldName + " = ?";

    }

    @Override
    public EntityClassMetaData<T> getEntityClassMetaData() {
        return entityClassMetaData;
    }


}
