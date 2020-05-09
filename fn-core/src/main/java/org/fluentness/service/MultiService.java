package org.fluentness.service;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

// By using this annotation on the service interfaces, all provided service implementations are
// instantiated, just like controllers and repositories
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface MultiService {
}
