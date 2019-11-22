package org.fluentness.repository;

import javax.persistence.Entity;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public interface Model {
    @Target(ElementType.FIELD)
    @Retention(RetentionPolicy.RUNTIME)
    @interface Field {

        Type value() default Type.TEXT;

    }


    static List<java.lang.reflect.Field> getModelFields(Object o) {
        return o.getClass().isAnnotationPresent(Entity.class) ?
            Arrays.stream(o.getClass().getDeclaredFields())
                .filter(field -> field.isAnnotationPresent(Field.class))
                .collect(Collectors.toList()) :
            new LinkedList<>();
    }


    enum Type {
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
