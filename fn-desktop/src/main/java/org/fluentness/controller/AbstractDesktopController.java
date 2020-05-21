package org.fluentness.controller;

import org.fluentness.view.AbstractDesktopView;

public abstract class AbstractDesktopController<V extends AbstractDesktopView> extends AbstractController<V> {

    public AbstractDesktopController(V view) {
        super(view);
    }


}
