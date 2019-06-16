package org.fluentness.common.generics;

import org.fluentness.common.logging.Log;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.HashMap;
import java.util.Map;

public interface Provider<T extends Component> extends Register<String, T> {

    Class<T> getProducedComponentType();

    default Map<String, T> retrieveAll() {
        // should only be called once by register
        Map<String, T> components = new HashMap<>();

        try {
            Field[] fields = this.getClass().getDeclaredFields();
            for (Field field : fields) {
                if (field.getModifiers() != 0) {
                    Log.INSTANCE.warning("Component %s->%s should have no modifiers, found %s",
                        this.getClass().getSimpleName(),
                        field.getName(),
                        Modifier.toString(field.getModifiers())
                    );
                }
                field.setAccessible(true);
                if (!getProducedComponentType().isAssignableFrom(field.get(this).getClass())) {
                    Log.INSTANCE.fatal("Component %s->%s should be of type %s, use consumer interfaces for dependency injection instead",
                        this.getClass().getSimpleName(),
                        field.getName(),
                        getProducedComponentType().getSimpleName()
                    );
                }
                T t = (T) field.get(this);
                components.put(field.getName(), t);
                field.setAccessible(false);
            }
        } catch (IllegalAccessException e) {
            Log.INSTANCE.error(e);
        }
        return components;
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

    default <A extends Annotation> A getAnnotation(String name, Class<? extends A> annotationClass) {
        Field[] fields = this.getClass().getDeclaredFields();
        for (Field field : fields) {
            if (field.getName().equals(name)) {
                return field.getAnnotation(annotationClass);
            }
        }
        return null;
    }
}
