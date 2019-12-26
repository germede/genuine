package org.fluentness.controller.web;

import org.fluentness.service.authenticator.Authenticator;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Action {

    String path();

    String[] method() default "GET";

    Class<? extends Authenticator>[] authenticators() default {};

    boolean cache() default true;
}
