package org.fluentness.view.component;

import org.fluentness.controller.event.OnClickEvent;

import javax.swing.*;

public class SwingButton extends JButton implements Button {

    public SwingButton(CharSequence text) {
        super(text.toString());
    }

    @Override
    public void setText(CharSequence text) {
        setText(text.toString());
    }

    @Override
    public void onClick(OnClickEvent<Button> onClickEvent) {
        addActionListener(button -> onClickEvent.handle(this));
    }
}
