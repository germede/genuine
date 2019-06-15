package org.fluentness.controller;

import org.fluentness.Fluentness;
import org.fluentness.base.onion.Consumer;

public interface ControllerConsumer<T extends ControllerProducer> extends Consumer {

    default T controller() {
        return (T) Fluentness.INSTANCE.controllers;
    }
}
