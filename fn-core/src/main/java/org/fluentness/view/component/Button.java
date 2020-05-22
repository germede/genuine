package org.fluentness.view.component;

import org.fluentness.view.action.Clickable;

public interface Button extends Component, Clickable<Button> {

    CharSequence getText();

    void setText(CharSequence text);

}
