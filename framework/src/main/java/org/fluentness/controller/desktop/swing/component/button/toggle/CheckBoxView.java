package org.fluentness.controller.desktop.swing.component.button.toggle;

import org.fluentness.controller.desktop.swing.component.button.AbstractButtonView;

import javax.swing.*;

public class CheckBoxView implements AbstractButtonView<CheckBoxView, JCheckBox> {

    JCheckBox jCheckBox = new JCheckBox();

    @Override
    public JCheckBox getView() {
        return jCheckBox;
    }

    public CheckBoxView borderPaintedFlat(boolean b) {
        jCheckBox.setBorderPaintedFlat(b);
        return this;
    }
}
