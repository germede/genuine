package org.fluentness.register;

import org.fluentness.common.Inject;
import org.fluentness.logging.Logger;

import java.lang.reflect.Field;

final class ClassInjector {

    static void injectFields(Object object) {
        Field[] declaredFields = object.getClass().getDeclaredFields();
        for (Field field : declaredFields) {
            try {
                if (field.isAnnotationPresent(Inject.class)) {
                    field.setAccessible(true);
                    field.set(object, field.getType().newInstance());
                    field.setAccessible(false);
                }
            } catch (Exception e) {
                Logger.error(ClassLoader.class, e);
            }
        }
    }
}
