package org.fluentness.model;

import org.fluentness.ApplicationComponent;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
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

}
