package org.fluentness.controller;

import android.view.View;
import org.fluentness.controller.event.AbstractEventController;
import org.fluentness.controller.event.Clickable;
import org.fluentness.controller.event.Handler;
import org.fluentness.view.AbstractMobileView;

public abstract class AbstractMobileController<M extends AbstractMobileView> extends AbstractEventController<M> {

    public AbstractMobileController(M view) {
        super(view);
    }

    @Override
    protected void onClick(Clickable clickable, Handler handler) {
        if( clickable instanceof View) {
            ((View) clickable).setOnClickListener(view -> handler.handle());
        }

    }
}
