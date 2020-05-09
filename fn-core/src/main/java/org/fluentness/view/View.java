package org.fluentness.view;

import org.fluentness.ApplicationComponent;

public interface View<T extends Template> extends ApplicationComponent {
    T getTemplate();
}
