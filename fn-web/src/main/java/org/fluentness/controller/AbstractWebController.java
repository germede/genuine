package org.fluentness.controller;

import org.fluentness.service.dispatcher.DynamicDispatcher;
import org.fluentness.view.AbstractWebView;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Method;
import java.util.Arrays;

import static org.fluentness.service.server.RequestMethod.GET;

public abstract class AbstractWebController<W extends AbstractWebView> implements Controller {

    private final W webView;
    protected final DynamicDispatcher dispatcher;

    public AbstractWebController(W webView, DynamicDispatcher dispatcher) {
        this.webView = webView;
        this.dispatcher = dispatcher;
        Arrays.stream(getActions()).forEach(action -> {
            Action annotation = action.getAnnotation(Action.class);
            dispatcher.addRoute(annotation.method(), annotation.path(), action, this);
        });
    }

    public final W getWebView() {
        return webView;
    }

    private Method[] getActions() {
        return Arrays.stream(this.getClass().getDeclaredMethods())
                .filter(method -> method.isAnnotationPresent(Action.class))
                .toArray(Method[]::new);
    }

    @Target(ElementType.METHOD)
    @Retention(RetentionPolicy.RUNTIME)
    protected @interface Action {
        String path();

        String method() default GET;
    }
}
