package org.fluentness.controller.desktop.swing.component.button.toggle;

import org.fluentness.controller.desktop.swing.component.button.AbstractButtonView;

import javax.swing.*;

public abstract class AbstractToggleButtonView<Self extends AbstractToggleButtonView, T extends JToggleButton> extends AbstractButtonView<Self, T> {

    @Override
    public abstract T getSwingView();

}
