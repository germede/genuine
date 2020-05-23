package org.fluentness.view.component;

import org.fluentness.controller.event.Clickable;

public interface Button extends Component, Clickable {

    CharSequence getText();

    void setText(CharSequence text);

}
