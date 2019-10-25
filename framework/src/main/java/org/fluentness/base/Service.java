package org.fluentness.base;

import org.fluentness.base.Component;

public interface Service<C extends Component> {

    default String translate(String key) {
        return "";
    }

}
