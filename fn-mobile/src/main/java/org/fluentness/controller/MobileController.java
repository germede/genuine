package org.fluentness.controller;

import android.view.View;
import org.fluentness.view.MobileView;
import org.fluentness.view.component.Component;
import org.fluentness.view.event.Handler;

public abstract class MobileController<M extends MobileView> extends ViewController<M> {

    public MobileController(M view) {
        super(view);
        MobileView.navigation.addItem(this);
    }

    @Override
    protected void onClick(Component component, Handler handler) {
        ((View) component).setOnClickListener(view -> handler.handle());
    }
}
