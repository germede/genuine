package org.fluentness.base.generics;

import org.fluentness.base.logging.Log;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

public interface Producer<T extends Component> extends Register<String, T> {

    Class<T> getProducedComponentType();

    default Map<String, T> retrieveAll() {
        checkProducerConsumerHierarchyCompatibility();

        Map<String, T> objects = new HashMap<>();
        try {
            Field[] fields = this.getClass().getDeclaredFields();
            for (Field field : fields) {
                field.setAccessible(true);
                if (!getProducedComponentType().isAssignableFrom(field.get(this).getClass())) {
                    Log.INSTANCE.error("Field %s->%s should be of type %s, use consumer interfaces for dependency injection instead",
                        this.getClass().getSimpleName(),
                        field.getName(),
                        getProducedComponentType().getSimpleName()
                    );
                    System.exit(1);
                }
                T t = (T) field.get(this);
                objects.put(field.getName(), t);
                field.setAccessible(false);
            }
        } catch (IllegalAccessException e) {
            Log.INSTANCE.error(e);
        }
        return objects;
    }

    default void checkProducerConsumerHierarchyCompatibility() {
        Class aClass = this.getClass();
        Class[] interfaces = aClass.getInterfaces();
        for (Class<?> anInterface : interfaces) {
            if (Consumer.class.isAssignableFrom(anInterface)) {
                Consumer consumerClass = (Consumer) this;


                Log.INSTANCE.warning(anInterface.getClass().getName());
                if (Fluentness.OnionHierarchy.INSTANCE.isOnionDependant(this.getClass().getSi, consumerClass) < 0) {
                    Log.INSTANCE.error("Producer %s should not depend on consumer %s due to onion hierarchy",
                        this.getClass().getSimpleName(),
                        consumerClass.getSimpleName()
                    );
                    System.exit(1);
                }
            }
        }
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
