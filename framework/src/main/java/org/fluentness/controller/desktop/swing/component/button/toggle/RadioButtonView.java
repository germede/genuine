package org.fluentness.controller.desktop.swing.component.button.toggle;

import javax.swing.*;

public class RadioButtonView extends AbstractToggleButtonView<RadioButtonView, JRadioButton> {

    private final JRadioButton jRadioButton = new JRadioButton();

    public RadioButtonView(String text) {
        text(text);
    }

    @Override
    public JRadioButton getSwingView() {
        return jRadioButton;
    }

}
