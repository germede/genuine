package org.fluentness.controller.web;

import org.fluentness.controller.Controller;

import java.lang.annotation.*;

import static org.fluentness.controller.web.AbstractWebController.HttpMethod.GET;

public abstract class AbstractWebController<V extends AbstractWebView> implements Controller {

    protected final V view;

    public AbstractWebController(V view) {
        this.view = view;
        view.setController(this);
    }

    public final V view() {
        return view;
    }

    @Override
    public Class<? extends Annotation> getActionClass() {
        return Action.class;
    }

    @Target(ElementType.METHOD)
    @Retention(RetentionPolicy.RUNTIME)
    public @interface Action {

        String path();

        HttpMethod method() default GET;

        String selector() default "";

        boolean authenticate() default false;

        boolean cache() default true;
    }


    protected enum HttpMethod {
        GET,
        HEAD,
        POST,
        PUT,
        DELETE,
        CONNECT,
        OPTIONS,
        TRACE,
        PATCH,
    }
}
