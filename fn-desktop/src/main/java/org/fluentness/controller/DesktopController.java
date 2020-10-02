package org.fluentness.controller;

import org.fluentness.view.DesktopView;
import org.fluentness.view.event.Clickable;
import org.fluentness.view.event.Handler;

import javax.swing.*;

public abstract class DesktopController<D extends DesktopView> extends ViewController<D> {

    public DesktopController(D view) {
        super(view);
    }

    protected void onClick(Clickable clickable, Handler handler) {
        if (clickable instanceof JButton) {
            ((JButton) clickable).addActionListener(button -> handler.handle());
        }
    }
}
