package org.fluentness.controller;

import android.view.View;
import org.fluentness.view.AbstractMobileView;
import org.fluentness.view.event.Clickable;
import org.fluentness.view.event.Handler;

public abstract class AbstractMobileController<M extends AbstractMobileView> extends AbstractViewController<M> {

    public AbstractMobileController(M view) {
        super(view);
        AbstractMobileView.navigation.addSectionFor(this);
    }

    protected void onClick(Clickable clickable, Handler handler) {

        if( clickable instanceof View) {
            ((View) clickable).setOnClickListener(view -> handler.handle());
        }

    }
}
