package org.fluentness.repository;

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

    int getId();

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

    @Repeatable(Translates.class)
    @Retention(RetentionPolicy.RUNTIME)
    @Target(ElementType.FIELD)
    protected @interface Translate {

        org.fluentness.base.service.localization.Language to();

        String as();

    }

    @Retention(RetentionPolicy.RUNTIME)
    @Target(ElementType.FIELD)
    protected @interface Translates {

        Translate[] value();

    }
}
