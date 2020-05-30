package org.fluentness.controller;

import org.fluentness.controller.event.AbstractEventController;
import org.fluentness.controller.event.Clickable;
import org.fluentness.controller.event.Handler;
import org.fluentness.view.AbstractDesktopView;

import javax.swing.*;

public abstract class AbstractDesktopController<D extends AbstractDesktopView> extends AbstractEventController<D> {

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
