package org.fluentness.repository;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public interface Model {
    default List<java.lang.reflect.Field> getFields() {
        return Arrays.stream(this.getClass().getDeclaredFields())
            .filter(field -> field.isAnnotationPresent(Field.class))
            .collect(Collectors.toList());
    }

    @Target(ElementType.FIELD)
    @Retention(RetentionPolicy.RUNTIME)
    @interface Field {
        Type type() default Type.TEXT;
        String label();
    }

    enum Type {
        CHECKBOX,
        COLOR,
        DATE,
        EMAIL,
        FILE,
        IMAGE,
        MONTH,
        NUMBER,
        PASSWORD,
        RADIO,
        RANGE,
        TEL,
        TEXT,
        TIME,
        URL,
        WEEK,
    }
}
