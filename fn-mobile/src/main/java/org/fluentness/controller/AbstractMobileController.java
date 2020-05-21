package org.fluentness.controller;

import org.fluentness.view.AbstractMobileView;

public abstract class AbstractMobileController<M extends AbstractMobileView> implements Controller {

    protected final M mobileView;

    public AbstractMobileController(M mobileView) {
        this.mobileView = mobileView;
    }

    public final M getMobileView() {
        return mobileView;
    }


}
