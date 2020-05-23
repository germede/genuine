package org.fluentness.controller;

import org.fluentness.controller.event.AbstractEventController;
import org.fluentness.controller.event.Clickable;
import org.fluentness.controller.event.OnClickEvent;
import org.fluentness.view.AbstractMobileView;

public abstract class AbstractMobileController<M extends AbstractMobileView> extends AbstractEventController<M> {

    public AbstractMobileController(M view) {
        super(view);
    }

    @Override
    protected void onClick(Clickable clickable, OnClickEvent onClickEvent) {

    }
}
