package org.fluentness.controller.desktop.swing.component.button.toggle;

import org.fluentness.controller.desktop.swing.component.button.AbstractButtonView;

import javax.swing.*;

public class ToggleButtonView implements AbstractButtonView<ToggleButtonView, JToggleButton> {

    JToggleButton jToggleButton = new JToggleButton();

    @Override
    public JToggleButton getView() {
        return jToggleButton;
    }

}
