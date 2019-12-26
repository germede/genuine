package org.fluentness.repository.crud;

import org.fluentness.repository.Model;
import org.fluentness.repository.Repository;
import org.fluentness.service.persistence.Persistence;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public abstract class AbstractCrudRepository<M extends Model> implements Repository<M> {

    protected final Class<M> modelClass;
    protected final String tableName;
    protected final Persistence persistence;

    protected AbstractCrudRepository(Class<M> modelClass, Persistence persistence) {
        this.modelClass = modelClass;
        this.tableName = modelClass.getSimpleName().toLowerCase();
        this.persistence = persistence;
    }

    public Class<M> getModelClass() {
        return modelClass;
    }

    public List<M> findAll() {
        return persistence.select(modelClass, "SELECT * FROM " + tableName);
    }

    public List<M> findByColumn(String key, Object value) {
        return persistence.select(modelClass, "SELECT * FROM " + tableName + " WHERE " + key + " = " + "'" + value + "'");
    }

    public M findById(int id) {
        List<M> select = persistence.select(modelClass, "SELECT * FROM " + tableName + " WHERE id = " + "'" + id + "'");
        return select.size() > 0 ? select.get(0) : null;
    }

    public int insert(M model) {
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

    public int update(M model) {
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

    public int delete(M model) {
        return persistence.persist("DELETE FROM " + tableName + " WHERE id = " + model.getId());
    }


}
