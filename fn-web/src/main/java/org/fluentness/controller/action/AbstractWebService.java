package org.fluentness.controller.action;

import org.fluentness.controller.WebController;
import org.fluentness.view.AbstractWebView;

import java.lang.annotation.*;

import static org.fluentness.service.server.RequestMethod.GET;

public abstract class AbstractWebService<W extends AbstractWebView> extends AbstractActionController implements WebController {

    private final String path;

    public AbstractWebService(String path) {
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
