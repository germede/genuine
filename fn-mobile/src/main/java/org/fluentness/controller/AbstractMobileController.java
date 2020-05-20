package org.fluentness.controller;

import org.fluentness.view.AbstractMobile;

public abstract class AbstractMobileController<M extends AbstractMobile> implements Controller {

    protected final M mobile;

    public AbstractMobileController(M mobile) {
        this.mobile = mobile;
    }

    public final M getMobile() {
        return mobile;
    }


}
