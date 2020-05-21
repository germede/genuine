package org.fluentness.controller;

import org.fluentness.view.AbstractMobileView;

public abstract class AbstractMobileController<M extends AbstractMobileView> extends AbstractController<M> {

    public AbstractMobileController(M mobileView) {
        super(mobileView);
    }

}
