package org.fluentness.controller.desktop.template.component.button;

import javax.swing.*;

public class ButtonView extends AbstractButtonView<ButtonView, JButton> {

    public ButtonView(String text) {
        super(new JButton(text));
    }

}
