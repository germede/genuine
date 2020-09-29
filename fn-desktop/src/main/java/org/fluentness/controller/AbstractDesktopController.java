package org.fluentness.controller;

import org.fluentness.view.AbstractDesktopView;
import org.fluentness.view.event.Clickable;
import org.fluentness.view.event.Handler;

import javax.swing.*;

public abstract class AbstractDesktopController<D extends AbstractDesktopView> extends AbstractViewController<D> {

    public AbstractDesktopController(D view) {
        super(view);
    }

    protected void onClick(Clickable clickable, Handler handler) {
        if (clickable instanceof JButton) {
            ((JButton) clickable).addActionListener(button -> handler.handle());
        }
    }
}
