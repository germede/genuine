package org.fluentness.view.component;

import org.fluentness.view.interaction.Clickable;

public interface Button extends Component, Clickable {

    CharSequence getText();

    void setText(CharSequence text);

}
