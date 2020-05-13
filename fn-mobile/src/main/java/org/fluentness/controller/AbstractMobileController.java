package org.fluentness.controller;

public abstract class AbstractMobileController<M extends AbstractMobile> implements Controller {

    private final M mobile;

    public AbstractMobileController(M mobile) {
        this.mobile = mobile;
    }

    public final M getMobile() {
        return mobile;
    }


}
