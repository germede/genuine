package org.fluentness.service.persistence;

import org.fluentness.model.PersistableModel;
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

    <M extends PersistableModel> M retrieve(Class<M> modelClass, long id);

    <M extends PersistableModel> List<M> retrieve(Class<M> modelClass, String... conditions);

    int persist(PersistableModel persistableModel);

    <M extends PersistableModel> int remove(Class<M> modelClass, long id);

    int remove(PersistableModel persistableModel);

    default String getPersistenceNameFor(Class<? extends PersistableModel> modelClass) {
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
