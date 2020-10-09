package org.fluentness.controller;

import org.fluentness.view.DesktopView;
import org.fluentness.view.component.Component;
import org.fluentness.view.event.Handler;

import javax.swing.*;

public abstract class DesktopController<D extends DesktopView> extends ViewController<D> {

    public DesktopController(D view) {
        super(view);
    }

    @Override
    protected void onClick(Component component, Handler handler) {
        if (component instanceof AbstractButton) {
            ((AbstractButton) component).addActionListener(button -> handler.handle());
        }
    }
}
