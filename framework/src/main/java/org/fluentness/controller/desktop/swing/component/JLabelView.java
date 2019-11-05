package org.fluentness.controller.desktop.swing.component;

import javax.swing.*;
import javax.swing.plaf.LabelUI;
import java.awt.*;

public class JLabelView implements JComponentView<JLabelView, JLabel> {

    private JLabel jLabel = new JLabel();

    @Override
    public JLabel getView() {
        return jLabel;
    }

    public JLabelView disabledIcon(Icon disabledIcon) {
        jLabel.setDisabledIcon(disabledIcon);
        return this;
    }

    public JLabelView displayedMnemonic(char aChar) {
        jLabel.setDisplayedMnemonic(aChar);
        return this;
    }

    public JLabelView displayedMnemonic(int key) {
        jLabel.setDisplayedMnemonic(key);
        return this;
    }

    public JLabelView displayedMnemonicIndex(int index) {
        jLabel.setDisplayedMnemonicIndex(index);
        return this;
    }

    public JLabelView horizontalAlignment(int alignment) {
        jLabel.setHorizontalAlignment(alignment);
        return this;
    }

    public JLabelView horizontalTextPosition(int textPosition) {
        jLabel.setHorizontalTextPosition(textPosition);
        return this;
    }

    public JLabelView icon(Icon icon) {
        jLabel.setIcon(icon);
        return this;
    }

    public JLabelView iconTextGap(int iconTextGap) {
        jLabel.setIconTextGap(iconTextGap);
        return this;
    }

    public JLabelView labelFor(Component c) {
        jLabel.setLabelFor(c);
        return this;
    }

    public JLabelView text(String text) {
        jLabel.setText(text);
        return this;
    }

    public JLabelView uI(LabelUI ui) {
        jLabel.setUI(ui);
        return this;
    }

    public JLabelView verticalAlignment(int alignment) {
        jLabel.setVerticalAlignment(alignment);
        return this;
    }

    public JLabelView verticalTextPosition(int textPosition) {
        jLabel.setVerticalTextPosition(textPosition);
        return this;
    }

}
