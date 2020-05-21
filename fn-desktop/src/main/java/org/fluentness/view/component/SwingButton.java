package org.fluentness.view.component;

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
    public void onClick(OnClickAction<Button> onClickAction) {
        addActionListener(button -> onClickAction.handle(this));
    }
}
