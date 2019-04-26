package org.fluentness.oop;

import org.fluentness.ann.Inject;

import java.lang.reflect.Field;

class Injector {
    static void injectFields(Object object) throws IllegalAccessException, InstantiationException {
        Field[] declaredFields = object.getClass().getDeclaredFields();
        for (Field declaredField : declaredFields) {
            if (declaredField.isAnnotationPresent(Inject.class)) {
                declaredField.set(object, declaredField.getType().newInstance());
            }
        }
    }
}
