package org.fluentness.controller.event;

import org.fluentness.controller.Controller;
import org.fluentness.view.View;

public abstract class AbstractEventController<V extends View> implements Controller {

    protected final V view;

    public AbstractEventController(V view) {
        this.view = view;
    }

    public final V getView() {
        return view;
    }

    protected abstract void onClick(Clickable clickable, Handler handler);

}
