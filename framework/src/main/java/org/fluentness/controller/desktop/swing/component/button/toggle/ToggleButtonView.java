package org.fluentness.controller.desktop.swing.component.button.toggle;

import javax.swing.*;

public class ToggleButtonView extends AbstractToggleButtonView<ToggleButtonView, JToggleButton> {

    JToggleButton jToggleButton = new JToggleButton();

    @Override
    public JToggleButton getView() {
        return jToggleButton;
    }

}
