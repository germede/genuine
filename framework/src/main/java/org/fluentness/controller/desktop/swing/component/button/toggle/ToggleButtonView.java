package org.fluentness.controller.desktop.swing.component.button.toggle;

import javax.swing.*;

public class ToggleButtonView extends AbstractToggleButtonView<ToggleButtonView, JToggleButton> {

    private final JToggleButton jToggleButton = new JToggleButton();

    @Override
    public JToggleButton getSwingView() {
        return jToggleButton;
    }

}
