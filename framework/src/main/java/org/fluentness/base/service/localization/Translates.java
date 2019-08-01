package org.fluentness.base.service.localization;

import java.lang.annotation.*;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@interface Translates {
    Translate[] value();
}
