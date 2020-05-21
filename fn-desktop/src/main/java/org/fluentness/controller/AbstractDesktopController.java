package org.fluentness.controller;

import org.fluentness.view.AbstractDesktopView;
import org.fluentness.view.event.Clickable;
import org.fluentness.controller.action.OnClickAction;

import javax.swing.*;

public abstract class AbstractDesktopController<V extends AbstractDesktopView> extends AbstractController<V> {

    public AbstractDesktopController(V view) {
        super(view);
    }

    protected void onClick(Clickable clickable, OnClickAction onClickAction) {
        if (clickable instanceof JButton) {
            ((JButton) clickable).addActionListener(actionEvent -> onClickAction.handle());
        }

    }

}
