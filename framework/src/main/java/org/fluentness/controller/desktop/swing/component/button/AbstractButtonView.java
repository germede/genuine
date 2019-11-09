package org.fluentness.controller.desktop.swing.component.button;

import org.fluentness.controller.desktop.swing.component.AbstractComponentView;

import javax.swing.*;
import javax.swing.event.ChangeListener;
import javax.swing.plaf.ButtonUI;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ItemListener;

public abstract class AbstractButtonView<Self extends AbstractButtonView, T extends AbstractButton> extends AbstractComponentView<Self, T> {

    @Override
    public abstract T getSwingView();

    public Self actionListener(ActionListener l) {
        getSwingView().addActionListener(l);
        return (Self) this;
    }

    public Self borderPainted(boolean b) {
        getSwingView().setBorderPainted(b);
        return (Self) this;
    }

    public Self changeListener(ChangeListener l) {
        getSwingView().addChangeListener(l);
        return (Self) this;
    }

    public Self contentAreaFilled(boolean b) {
        getSwingView().setContentAreaFilled(b);
        return (Self) this;
    }

    public Self disabledIcon(Icon disabledIcon) {
        getSwingView().setDisabledIcon(disabledIcon);
        return (Self) this;
    }

    public Self disabledSelectedIcon(Icon disabledSelectedIcon) {
        getSwingView().setDisabledSelectedIcon(disabledSelectedIcon);
        return (Self) this;
    }

    public Self displayedMnemonicIndex(int index) {
        getSwingView().setDisplayedMnemonicIndex(index);
        return (Self) this;
    }

    public Self focusPainted(boolean b) {
        getSwingView().setFocusPainted(b);
        return (Self) this;
    }

    public Self hideActionText(boolean hideActionText) {
        getSwingView().setHideActionText(hideActionText);
        return (Self) this;
    }

    public Self horizontalAlignment(int alignment) {
        getSwingView().setHorizontalAlignment(alignment);
        return (Self) this;
    }

    public Self horizontalTextPosition(int textPosition) {
        getSwingView().setHorizontalTextPosition(textPosition);
        return (Self) this;
    }

    public Self icon(Icon icon) {
        getSwingView().setIcon(icon);
        return (Self) this;
    }

    public Self iconTextGap(int iconTextGap) {
        getSwingView().setIconTextGap(iconTextGap);
        return (Self) this;
    }

    public Self itemListener(ItemListener l) {
        getSwingView().addItemListener(l);
        return (Self) this;
    }

    public Self margin(Insets m) {
        getSwingView().setMargin(m);
        return (Self) this;
    }

    public Self mnemonic(char mnemonic) {
        getSwingView().setMnemonic(mnemonic);
        return (Self) this;
    }

    public Self mnemonic(int mnemonic) {
        getSwingView().setMnemonic(mnemonic);
        return (Self) this;
    }

    public Self multiClickThreshold(long threshold) {
        getSwingView().setMultiClickThreshhold(threshold);
        return (Self) this;
    }

    public Self pressedIcon(Icon pressedIcon) {
        getSwingView().setPressedIcon(pressedIcon);
        return (Self) this;
    }

    public Self rolloverEnabled(boolean b) {
        getSwingView().setRolloverEnabled(b);
        return (Self) this;
    }

    public Self rolloverIcon(Icon rolloverIcon) {
        getSwingView().setRolloverIcon(rolloverIcon);
        return (Self) this;
    }

    public Self rolloverSelectedIcon(Icon rolloverSelectedIcon) {
        getSwingView().setRolloverSelectedIcon(rolloverSelectedIcon);
        return (Self) this;
    }

    public Self selected(boolean b) {
        getSwingView().setSelected(b);
        return (Self) this;
    }

    public Self selectedIcon(Icon selectedIcon) {
        getSwingView().setSelectedIcon(selectedIcon);
        return (Self) this;
    }

    public Self text(String text) {
        getSwingView().setText(text);
        return (Self) this;
    }

    public Self uI(ButtonUI ui) {
        getSwingView().setUI(ui);
        return (Self) this;
    }

    public Self verticalAlignment(int alignment) {
        getSwingView().setVerticalAlignment(alignment);
        return (Self) this;
    }

    public Self verticalTextPosition(int textPosition) {
        getSwingView().setVerticalTextPosition(textPosition);
        return (Self) this;
    }
}
