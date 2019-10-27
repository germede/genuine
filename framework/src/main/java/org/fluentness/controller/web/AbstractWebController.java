package org.fluentness.controller.web;

import org.fluentness.controller.Controller;
import org.fluentness.service.server.HttpMethod;

import java.lang.reflect.Method;

public abstract class AbstractWebController implements Controller {

    @Override
    public Method[] getActions() {
        return new Method[0];
    }

    protected @interface Action {
        String path();
        HttpMethod method() default HttpMethod.GET;
    }
}
