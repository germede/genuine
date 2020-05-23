package org.fluentness.service;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

// By using this annotation on the application class hierarchy,
// the provided service implementations are registered for possible instantiation
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface Services {
    Class<? extends Service>[] value();
}
