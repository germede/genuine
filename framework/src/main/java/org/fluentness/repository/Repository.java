package org.fluentness.repository;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public interface Repository<M extends Model> {

    default List<M> findAll() {
        return persistence.select(modelClass, "SELECT * FROM " + tableName);
    }

    default List<M> findByColumn(String key, Object value) {
        return persistence.select(modelClass, "SELECT * FROM " + tableName + " WHERE " + key + " = " + "'" + value + "'");
    }

    default M findById(int id) {
        List<M> select = persistence.select(modelClass, "SELECT * FROM " + tableName + " WHERE id = " + "'" + id + "'");
        return select.size() > 0 ? select.get(0) : null;
    }

    default int insert(M model) {
        String into = Arrays.stream(model.getClass().getDeclaredFields()).map(Field::getName).collect(Collectors.joining(","));

        StringBuilder values = new StringBuilder();
        Field[] declaredFields = model.getClass().getDeclaredFields();
        try {
            for (int i = 0; i < declaredFields.length; i++) {
                values.append(i == 0 ? "" : ", ").append(declaredFields[i].get(model));
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        return persistence.persist("INSERT INTO " + tableName + "(" + into + ") " + "VALUES (" + values.toString() + ")");
    }

    default int update(M model) {
        StringBuilder set = new StringBuilder();
        try {
            Field[] declaredFields = model.getClass().getDeclaredFields();
            for (int i = 0; i < declaredFields.length; i++) {
                Field field = declaredFields[i];
                field.setAccessible(true);
                set.append(i == 0 ? "" : ", ").append(field.getName()).append(" = ").append(field.get(model));
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        return persistence.persist("UPDATE " + tableName + " SET " + set.toString() + " WHERE id = " + model.getId());
    }

    default int delete(M model) {
        return persistence.persist("DELETE FROM " + tableName + " WHERE id = " + model.getId());
    }


}
