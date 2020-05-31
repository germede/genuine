package org.fluentness.view.component.text;

import org.fluentness.controller.view.event.Clickable;

public interface Button extends Text, Clickable {

    enum Type {
        PRIMARY,
        SECONDARY,
        SUCCESS,
        WARNING,
        DANGER,
        LIGHT,
        DARK,
        TRANSPARENT,
        DISABLED,
    }

    Type getType();

}
