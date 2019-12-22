package org.fluentness.controller.desktop.view.component.button.toggle;

import org.fluentness.controller.desktop.view.component.button.AbstractButtonView;

import javax.swing.*;

public abstract class AbstractToggleButtonView<Self extends AbstractToggleButtonView, View extends JToggleButton> extends AbstractButtonView<Self, View> {

    public AbstractToggleButtonView(View view) {
        super(view);
    }

}
