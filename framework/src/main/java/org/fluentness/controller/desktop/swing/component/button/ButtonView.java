package org.fluentness.controller.desktop.swing.component.button;

import javax.swing.*;

public class ButtonView extends AbstractButtonView<ButtonView, JButton> {

    private final JButton jButton = new JButton();

    @Override
    public JButton getSwingView() {
        return jButton;
    }

}
