package org.fluentness.base.service.configuration;

import org.fluentness.base.service.localization.Language;

import java.lang.annotation.*;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Repeatable(Environments.class)
public @interface Environment {
    Language to();
    String as();
}
