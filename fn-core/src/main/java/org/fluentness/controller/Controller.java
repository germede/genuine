package org.fluentness.controller;

import java.lang.reflect.Method;

public interface Controller {

    default Method[] getActions() {
        return this.getClass().getMethods();
    }

}
