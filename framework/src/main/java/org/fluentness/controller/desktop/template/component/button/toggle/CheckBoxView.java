package org.fluentness.controller.desktop.template.component.button.toggle;

import javax.swing.*;

public class CheckBoxView extends AbstractToggleButtonView<CheckBoxView, JCheckBox> {

    public CheckBoxView(String text) {
        super(new JCheckBox(text));
    }

    public CheckBoxView borderPaintedFlat(boolean b) {
        view.setBorderPaintedFlat(b);
        return this;
    }
}
