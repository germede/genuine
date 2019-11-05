package org.fluentness.controller.desktop.swing.component;

import javax.swing.*;
import javax.swing.plaf.LabelUI;
import java.awt.*;

public class LabelView implements ComponentView<LabelView, JLabel> {

    private JLabel jLabel = new JLabel();

    @Override
    public JLabel getView() {
        return jLabel;
    }

    public LabelView disabledIcon(Icon disabledIcon) {
        jLabel.setDisabledIcon(disabledIcon);
        return this;
    }

    public LabelView displayedMnemonic(char aChar) {
        jLabel.setDisplayedMnemonic(aChar);
        return this;
    }

    public LabelView displayedMnemonic(int key) {
        jLabel.setDisplayedMnemonic(key);
        return this;
    }

    public LabelView displayedMnemonicIndex(int index) {
        jLabel.setDisplayedMnemonicIndex(index);
        return this;
    }

    public LabelView horizontalAlignment(int alignment) {
        jLabel.setHorizontalAlignment(alignment);
        return this;
    }

    public LabelView horizontalTextPosition(int textPosition) {
        jLabel.setHorizontalTextPosition(textPosition);
        return this;
    }

    public LabelView icon(Icon icon) {
        jLabel.setIcon(icon);
        return this;
    }

    public LabelView iconTextGap(int iconTextGap) {
        jLabel.setIconTextGap(iconTextGap);
        return this;
    }

    public LabelView labelFor(Component c) {
        jLabel.setLabelFor(c);
        return this;
    }

    public LabelView text(String text) {
        jLabel.setText(text);
        return this;
    }

    public LabelView uI(LabelUI ui) {
        jLabel.setUI(ui);
        return this;
    }

    public LabelView verticalAlignment(int alignment) {
        jLabel.setVerticalAlignment(alignment);
        return this;
    }

    public LabelView verticalTextPosition(int textPosition) {
        jLabel.setVerticalTextPosition(textPosition);
        return this;
    }

}
