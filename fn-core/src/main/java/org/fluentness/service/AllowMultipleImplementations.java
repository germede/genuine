package org.fluentness.service;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

// By using this annotation on the service interface,
// multiple implementations will be instantiated when needed and injected when ServiceClass[] constructor parameter
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface AllowMultipleImplementations {
}
