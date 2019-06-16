package org.fluentness.controller;

import org.fluentness.Fluentness;
import org.fluentness.common.components.Consumer;

public interface ControllerConsumer<T extends ControllerProvider> extends Consumer {

    default T controller() {
        return (T) Fluentness.INSTANCE.controllers;
    }
}
