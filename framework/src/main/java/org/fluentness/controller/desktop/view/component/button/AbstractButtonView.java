package org.fluentness.controller.desktop.view.component.button;

import org.fluentness.controller.desktop.view.component.AbstractComponentView;

import javax.swing.*;
import javax.swing.event.ChangeListener;
import javax.swing.plaf.ButtonUI;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ItemListener;

public abstract class AbstractButtonView<Self extends AbstractButtonView, View extends AbstractButton> extends AbstractComponentView<Self, View> {

    public AbstractButtonView(View view) {
        super(view);
    }

    public Self actionListener(ActionListener l) {
        view.addActionListener(l);
        return (Self) this;
    }

    public Self borderPainted(boolean b) {
        view.setBorderPainted(b);
        return (Self) this;
    }

    public Self changeListener(ChangeListener l) {
        view.addChangeListener(l);
        return (Self) this;
    }

    public Self contentAreaFilled(boolean b) {
        view.setContentAreaFilled(b);
        return (Self) this;
    }

    public Self disabledIcon(Icon disabledIcon) {
        view.setDisabledIcon(disabledIcon);
        return (Self) this;
    }

    public Self disabledSelectedIcon(Icon disabledSelectedIcon) {
        view.setDisabledSelectedIcon(disabledSelectedIcon);
        return (Self) this;
    }

    public Self displayedMnemonicIndex(int index) {
        view.setDisplayedMnemonicIndex(index);
        return (Self) this;
    }

    public Self focusPainted(boolean b) {
        view.setFocusPainted(b);
        return (Self) this;
    }

    public Self hideActionText(boolean hideActionText) {
        view.setHideActionText(hideActionText);
        return (Self) this;
    }

    public Self horizontalAlignment(int alignment) {
        view.setHorizontalAlignment(alignment);
        return (Self) this;
    }

    public Self horizontalTextPosition(int textPosition) {
        view.setHorizontalTextPosition(textPosition);
        return (Self) this;
    }

    public Self icon(Icon icon) {
        view.setIcon(icon);
        return (Self) this;
    }

    public Self iconTextGap(int iconTextGap) {
        view.setIconTextGap(iconTextGap);
        return (Self) this;
    }

    public Self itemListener(ItemListener l) {
        view.addItemListener(l);
        return (Self) this;
    }

    public Self margin(Insets m) {
        view.setMargin(m);
        return (Self) this;
    }

    public Self mnemonic(char mnemonic) {
        view.setMnemonic(mnemonic);
        return (Self) this;
    }

    public Self mnemonic(int mnemonic) {
        view.setMnemonic(mnemonic);
        return (Self) this;
    }

    public Self multiClickThreshold(long threshold) {
        view.setMultiClickThreshhold(threshold);
        return (Self) this;
    }

    public Self pressedIcon(Icon pressedIcon) {
        view.setPressedIcon(pressedIcon);
        return (Self) this;
    }

    public Self rolloverEnabled(boolean b) {
        view.setRolloverEnabled(b);
        return (Self) this;
    }

    public Self rolloverIcon(Icon rolloverIcon) {
        view.setRolloverIcon(rolloverIcon);
        return (Self) this;
    }

    public Self rolloverSelectedIcon(Icon rolloverSelectedIcon) {
        view.setRolloverSelectedIcon(rolloverSelectedIcon);
        return (Self) this;
    }

    public Self selected(boolean b) {
        view.setSelected(b);
        return (Self) this;
    }

    public Self selectedIcon(Icon selectedIcon) {
        view.setSelectedIcon(selectedIcon);
        return (Self) this;
    }

    public Self text(String text) {
        view.setText(text);
        return (Self) this;
    }

    public Self uI(ButtonUI ui) {
        view.setUI(ui);
        return (Self) this;
    }

    public Self verticalAlignment(int alignment) {
        view.setVerticalAlignment(alignment);
        return (Self) this;
    }

    public Self verticalTextPosition(int textPosition) {
        view.setVerticalTextPosition(textPosition);
        return (Self) this;
    }
}
