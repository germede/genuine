package org.fluentness.controller.desktop.template.component;

import javax.swing.*;
import javax.swing.plaf.LabelUI;
import java.awt.*;

public class LabelView extends AbstractComponentView<LabelView, JLabel> {

    public LabelView() {
        super(new JLabel());
    }

    public LabelView disabledIcon(Icon disabledIcon) {
        view.setDisabledIcon(disabledIcon);
        return this;
    }

    public LabelView displayedMnemonic(char aChar) {
        view.setDisplayedMnemonic(aChar);
        return this;
    }

    public LabelView displayedMnemonic(int key) {
        view.setDisplayedMnemonic(key);
        return this;
    }

    public LabelView displayedMnemonicIndex(int index) {
        view.setDisplayedMnemonicIndex(index);
        return this;
    }

    public LabelView horizontalAlignment(int alignment) {
        view.setHorizontalAlignment(alignment);
        return this;
    }

    public LabelView horizontalTextPosition(int textPosition) {
        view.setHorizontalTextPosition(textPosition);
        return this;
    }

    public LabelView icon(Icon icon) {
        view.setIcon(icon);
        return this;
    }

    public LabelView iconTextGap(int iconTextGap) {
        view.setIconTextGap(iconTextGap);
        return this;
    }

    public LabelView labelFor(Component c) {
        view.setLabelFor(c);
        return this;
    }

    public LabelView text(String text) {
        view.setText(text);
        return this;
    }

    public LabelView uI(LabelUI ui) {
        view.setUI(ui);
        return this;
    }

    public LabelView verticalAlignment(int alignment) {
        view.setVerticalAlignment(alignment);
        return this;
    }

    public LabelView verticalTextPosition(int textPosition) {
        view.setVerticalTextPosition(textPosition);
        return this;
    }

}
