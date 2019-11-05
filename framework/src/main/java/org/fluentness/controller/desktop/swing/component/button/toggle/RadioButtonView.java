package org.fluentness.controller.desktop.swing.component.button.toggle;

import org.fluentness.controller.desktop.swing.component.button.AbstractButtonView;

import javax.swing.*;

public class RadioButtonView implements AbstractButtonView<RadioButtonView, JRadioButton> {

    JRadioButton jRadioButton = new JRadioButton();

    @Override
    public JRadioButton getView() {
        return jRadioButton;
    }

}
