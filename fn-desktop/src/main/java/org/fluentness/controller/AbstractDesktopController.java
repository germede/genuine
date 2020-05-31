package org.fluentness.controller;

import org.fluentness.controller.view.AbstractViewController;
import org.fluentness.controller.view.event.Clickable;
import org.fluentness.controller.view.event.Handler;
import org.fluentness.view.AbstractDesktopView;

import javax.swing.*;

public abstract class AbstractDesktopController<D extends AbstractDesktopView> extends AbstractViewController<D> {

    public AbstractDesktopController(D view) {
        super(view);
    }

    @Override
    protected void onClick(Clickable clickable, Handler handler) {
        if (clickable instanceof JButton) {
            ((JButton) clickable).addActionListener(button -> handler.handle());
        }
    }
}
