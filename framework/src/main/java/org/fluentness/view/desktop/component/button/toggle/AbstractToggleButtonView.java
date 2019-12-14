package org.fluentness.view.desktop.component.button.toggle;

import org.fluentness.view.desktop.component.button.AbstractButtonView;

import javax.swing.*;

public abstract class AbstractToggleButtonView<Self extends AbstractToggleButtonView, View extends JToggleButton> extends AbstractButtonView<Self, View> {

    public AbstractToggleButtonView(View view) {
        super(view);
    }

}
