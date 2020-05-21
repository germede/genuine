package org.fluentness.view.component;

import org.fluentness.view.event.Clickable;

public interface Button extends Component, Clickable {

    String getText();

    void setText(String text);

}
