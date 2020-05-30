package org.fluentness.controller.action;

import org.fluentness.controller.WebController;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static org.fluentness.service.server.RequestMethod.GET;

public abstract class AbstractWebActionController extends AbstractActionController implements WebController {

    private final String path;

    public AbstractWebActionController(String path) {
        super(Action.class);
        this.path = path;
    }

    @Override
    public final String getPath() {
        return path;
    }

    @Target(ElementType.METHOD)
    @Retention(RetentionPolicy.RUNTIME)
    public @interface Action {

        String path();

        String method() default GET;
    }
}
