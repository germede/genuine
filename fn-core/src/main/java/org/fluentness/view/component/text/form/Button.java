package org.fluentness.view.component.text.form;

import org.fluentness.controller.view.event.Clickable;
import org.fluentness.view.component.text.Text;

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
