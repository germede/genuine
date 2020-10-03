package org.fluentness.view.component.text;

public interface Button extends Text {

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
