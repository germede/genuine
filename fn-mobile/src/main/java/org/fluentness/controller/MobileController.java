package org.fluentness.controller;

import android.view.View;
import org.fluentness.view.MobileView;
import org.fluentness.view.event.Clickable;
import org.fluentness.view.event.Handler;

public abstract class MobileController<M extends MobileView> extends ViewController<M> {

    public MobileController(M view) {
        super(view);
        MobileView.navigation.addItem(this);
    }

    protected void onClick(Clickable clickable, Handler handler) {

        if( clickable instanceof View) {
            ((View) clickable).setOnClickListener(view -> handler.handle());
        }

    }
}
