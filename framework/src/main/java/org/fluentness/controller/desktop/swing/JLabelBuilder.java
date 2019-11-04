package org.fluentness.controller.desktop.swing;

import javax.swing.*;
import javax.swing.plaf.LabelUI;
import java.awt.*;

public class JLabelBuilder implements JComponentBuilder<JLabelBuilder, JLabel> {

    private JLabel jLabel = new JLabel();

    @Override
    public JLabel getJComponent() {
        return jLabel;
    }

    public JLabelBuilder disabledIcon(Icon disabledIcon) {
        jLabel.setDisabledIcon(disabledIcon);
        return this;
    }

    public JLabelBuilder displayedMnemonic(char aChar) {
        jLabel.setDisplayedMnemonic(aChar);
        return this;
    }

    public JLabelBuilder displayedMnemonic(int key) {
        jLabel.setDisplayedMnemonic(key);
        return this;
    }

    public JLabelBuilder displayedMnemonicIndex(int index) {
        jLabel.setDisplayedMnemonicIndex(index);
        return this;
    }

    public JLabelBuilder horizontalAlignment(int alignment) {
        jLabel.setHorizontalAlignment(alignment);
        return this;
    }

    public JLabelBuilder horizontalTextPosition(int textPosition) {
        jLabel.setHorizontalTextPosition(textPosition);
        return this;
    }

    public JLabelBuilder icon(Icon icon) {
        jLabel.setIcon(icon);
        return this;
    }

    public JLabelBuilder iconTextGap(int iconTextGap) {
        jLabel.setIconTextGap(iconTextGap);
        return this;
    }

    public JLabelBuilder labelFor(Component c) {
        jLabel.setLabelFor(c);
        return this;
    }

    public JLabelBuilder text(String text) {
        jLabel.setText(text);
        return this;
    }

    public JLabelBuilder uI(LabelUI ui) {
        jLabel.setUI(ui);
        return this;
    }

    public JLabelBuilder verticalAlignment(int alignment) {
        jLabel.setVerticalAlignment(alignment);
        return this;
    }

    public JLabelBuilder verticalTextPosition(int textPosition) {
        jLabel.setVerticalTextPosition(textPosition);
        return this;
    }

}
