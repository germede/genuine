package org.fluentness.service.persistence;

import org.fluentness.model.Model;
import org.fluentness.service.Service;
import org.fluentness.service.configuration.Setting;

import java.lang.reflect.Field;
import java.util.List;

public interface Persistence extends Service {

    Setting<String> DRIVER = new Setting<>();
    Setting<String> HOST = new Setting<>();
    Setting<Integer> PORT = new Setting<>();
    Setting<String> DATABASE = new Setting<>();
    Setting<String> URL_PARAMETER_QUERY = new Setting<>("");
    Setting<String> USERNAME = new Setting<>();
    Setting<String> PASSWORD = new Setting<>();

    <M extends Model> M retrieve(Class<M> modelClass, long id);

    <M extends Model> List<M> retrieve(Class<M> modelClass, String... conditions);

    int persist(Model model);

    <M extends Model> int remove(Class<M> modelClass, long id);

    int remove(Model model);

    default String getPersistenceNameFor(Class<? extends Model> modelClass) {
        return modelClass.getSimpleName().toLowerCase();
    }

    static void setFieldUsingReflection(Object object, String fieldName, Object value) {
        try {
            Field field = object.getClass().getField(fieldName);
            field.setAccessible(true);
            field.set(object, value);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
