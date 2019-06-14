package org.fluentness.base.generics;

import org.fluentness.base.logging.Log;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

public interface Provider<T> {

    default Map<String, T> getAll() {
        Map<String, T> objects = new HashMap<>();
        try {
            Field[] fields = this.getClass().getDeclaredFields();
            for (Field field : fields) {
                field.setAccessible(true);
                T t = (T) field.get(this);
                objects.put(field.getName(), t);
                field.setAccessible(false);
            }
        } catch (IllegalAccessException e) {
            Log.error(e);
        }
        return objects;
    }

    default T get(String name) {
        return getAll().get(name);
    }

    default String getNameFor(T t) {
        for (Map.Entry<String, T> entry : getAll().entrySet()) {
            if (entry.getValue().equals(t)) {
                return entry.getKey();
            }
        }
        return null;
    }

    default boolean contains(T t) {
        return getAll().containsValue(t);
    }

    default boolean isAnnotationPresent(String name, Class<? extends Annotation> annotationClass) {
        Field[] fields = this.getClass().getDeclaredFields();
        for (Field field : fields) {
            if (field.getName().equals(name) && field.isAnnotationPresent(annotationClass)) {
                return true;
            }
        }
        return false;
    }

    default Annotation getAnnotation(String name, Class<? extends Annotation> annotationClass) {
        Field[] fields = this.getClass().getDeclaredFields();
        for (Field field : fields) {
            if (field.getName().equals(name)) {
                return field.getAnnotation(annotationClass);
            }
        }
        return null;
    }

}
