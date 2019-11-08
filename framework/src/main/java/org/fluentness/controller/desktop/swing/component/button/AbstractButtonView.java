package org.fluentness.controller.desktop.swing.component.button;

import org.fluentness.controller.desktop.swing.component.AbstractComponentView;

import javax.swing.*;
import javax.swing.plaf.ButtonUI;
import java.awt.*;

public abstract class AbstractButtonView<Self extends AbstractButtonView, T extends AbstractButton> extends AbstractComponentView<Self, T> {

    @Override
    public abstract T getView();

    public Self action(Action a) {
        getView().setAction(a);
        return (Self) this;
    }

    public Self actionCommand(String actionCommand) {
        getView().setActionCommand(actionCommand);
        return (Self) this;
    }

    public Self borderPainted(boolean b) {
        getView().setBorderPainted(b);
        return (Self) this;
    }

    public Self contentAreaFilled(boolean b) {
        getView().setContentAreaFilled(b);
        return (Self) this;
    }

    public Self disabledIcon(Icon disabledIcon) {
        getView().setDisabledIcon(disabledIcon);
        return (Self) this;
    }

    public Self disabledSelectedIcon(Icon disabledSelectedIcon) {
        getView().setDisabledSelectedIcon(disabledSelectedIcon);
        return (Self) this;
    }

    public Self displayedMnemonicIndex(int index) {
        getView().setDisplayedMnemonicIndex(index);
        return (Self) this;
    }

    public Self focusPainted(boolean b) {
        getView().setFocusPainted(b);
        return (Self) this;
    }

    public Self hideActionText(boolean hideActionText) {
        getView().setHideActionText(hideActionText);
        return (Self) this;
    }

    public Self horizontalAlignment(int alignment) {
        getView().setHorizontalAlignment(alignment);
        return (Self) this;
    }

    public Self horizontalTextPosition(int textPosition) {
        getView().setHorizontalTextPosition(textPosition);
        return (Self) this;
    }

    public Self icon(Icon publicIcon) {
        getView().setIcon(publicIcon);
        return (Self) this;
    }

    public Self iconTextGap(int iconTextGap) {
        getView().setIconTextGap(iconTextGap);
        return (Self) this;
    }

    public Self layout(LayoutManager mgr) {
        getView().setLayout(mgr);
        return (Self) this;
    }

    public Self margin(Insets m) {
        getView().setMargin(m);
        return (Self) this;
    }

    public Self mnemonic(char mnemonic) {
        getView().setMnemonic(mnemonic);
        return (Self) this;
    }

    public Self mnemonic(int mnemonic) {
        getView().setMnemonic(mnemonic);
        return (Self) this;
    }

    public Self model(ButtonModel newModel) {
        getView().setModel(newModel);
        return (Self) this;
    }

    public Self multiClickThreshhold(long threshhold) {
        getView().setMultiClickThreshhold(threshhold);
        return (Self) this;
    }

    public Self pressedIcon(Icon pressedIcon) {
        getView().setPressedIcon(pressedIcon);
        return (Self) this;
    }

    public Self rolloverEnabled(boolean b) {
        getView().setRolloverEnabled(b);
        return (Self) this;
    }

    public Self rolloverIcon(Icon rolloverIcon) {
        getView().setRolloverIcon(rolloverIcon);
        return (Self) this;
    }

    public Self rolloverSelectedIcon(Icon rolloverSelectedIcon) {
        getView().setRolloverSelectedIcon(rolloverSelectedIcon);
        return (Self) this;
    }

    public Self selected(boolean b) {
        getView().setSelected(b);
        return (Self) this;
    }

    public Self selectedIcon(Icon selectedIcon) {
        getView().setSelectedIcon(selectedIcon);
        return (Self) this;
    }

    public Self text(String text) {
        getView().setText(text);
        return (Self) this;
    }

    public Self uI(ButtonUI ui) {
        getView().setUI(ui);
        return (Self) this;
    }

    public Self verticalAlignment(int alignment) {
        getView().setVerticalAlignment(alignment);
        return (Self) this;
    }

    public Self verticalTextPosition(int textPosition) {
        getView().setVerticalTextPosition(textPosition);
        return (Self) this;
    }
}
