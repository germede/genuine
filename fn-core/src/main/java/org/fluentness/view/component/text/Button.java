package org.fluentness.view.component.text;

import org.fluentness.controller.event.Clickable;
import org.fluentness.view.component.Component;

public interface Button extends Component, Clickable {

    CharSequence getText();

    void setText(CharSequence text);

}
