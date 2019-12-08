package org.fluentness.repository;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Method;
import java.util.Arrays;

public interface Model {
    static Method[] getGetters(Class<? extends Model> modelClass) {
        return Arrays.stream(modelClass.getMethods())
            .filter(method -> method.getName().startsWith("get"))
            .toArray(Method[]::new);
    }

    static Method[] getSetters(Class<? extends Model> modelClass) {
        return Arrays.stream(modelClass.getMethods())
            .filter(method -> method.getName().startsWith("set"))
            .toArray(Method[]::new);
    }


    @Target(ElementType.FIELD)
    @Retention(RetentionPolicy.RUNTIME)
    @interface Type {


        FieldType value() default FieldType.TEXT;

    }

    enum FieldType {
        CHECKBOX,
        COLOR,
        DATE,
        EMAIL,
        FILE,
        IMAGE,
        NUMBER,
        PASSWORD,
        RADIO,
        RANGE,
        TEL,
        TEXT,
        TIME,
        URL,
        SELECT;
    }
}
