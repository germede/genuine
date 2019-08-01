package org.fluentness.quatsch;

import java.lang.annotation.*;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Translates {
    Translate[] value();
}
