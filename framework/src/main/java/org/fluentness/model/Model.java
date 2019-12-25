package org.fluentness.model;

import org.fluentness.ApplicationComponent;

import java.lang.annotation.*;
import java.lang.reflect.Method;
import java.util.Arrays;

public interface Model extends ApplicationComponent {

    default Method[] getGetters() {
        return Arrays.stream(this.getClass().getMethods())
            .filter(method -> method.getName().startsWith("get") || method.getName().startsWith("is"))
            .toArray(Method[]::new);
    }

    default Method[] getSetters() {
        return Arrays.stream(this.getClass().getMethods())
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
