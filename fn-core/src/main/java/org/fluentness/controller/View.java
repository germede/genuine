package org.fluentness.controller;

import org.fluentness.ApplicationComponent;

public interface View<T extends Template> extends ApplicationComponent {
    T getTemplate();
}
