package org.fluentness.controller;

import org.fluentness.view.View;
import org.fluentness.view.interaction.Clickable;
import org.fluentness.controller.action.OnClickAction;

public abstract class AbstractController<V extends View> implements Controller {

    private final V view;

    public AbstractController(V view) {
        this.view = view;
    }

    public final V getView() {
        return view;
    }

    protected abstract void onClick(Clickable clickable, OnClickAction onClickAction);

}
