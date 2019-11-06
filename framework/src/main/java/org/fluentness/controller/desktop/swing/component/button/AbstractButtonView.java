package org.fluentness.controller.desktop.swing.component.button;

import org.fluentness.controller.desktop.swing.component.ComponentView;

import javax.swing.*;
import javax.swing.plaf.ButtonUI;
import java.awt.*;

public interface AbstractButtonView<Self extends AbstractButtonView, B extends AbstractButton> extends ComponentView<Self, B> {

    @Override
    B getView();

    default Self action(Action a) {
        getView().setAction(a);
        return (Self) this;
    }

    default Self actionCommand(String actionCommand) {
        getView().setActionCommand(actionCommand);
        return (Self) this;
    }

    default Self borderPainted(boolean b) {
        getView().setBorderPainted(b);
        return (Self) this;
    }

    default Self contentAreaFilled(boolean b) {
        getView().setContentAreaFilled(b);
        return (Self) this;
    }

    default Self disabledIcon(Icon disabledIcon) {
        getView().setDisabledIcon(disabledIcon);
        return (Self) this;
    }

    default Self disabledSelectedIcon(Icon disabledSelectedIcon) {
        getView().setDisabledSelectedIcon(disabledSelectedIcon);
        return (Self) this;
    }

    default Self displayedMnemonicIndex(int index) {
        getView().setDisplayedMnemonicIndex(index);
        return (Self) this;
    }

    default Self focusPainted(boolean b) {
        getView().setFocusPainted(b);
        return (Self) this;
    }

    default Self hideActionText(boolean hideActionText) {
        getView().setHideActionText(hideActionText);
        return (Self) this;
    }

    default Self horizontalAlignment(int alignment) {
        getView().setHorizontalAlignment(alignment);
        return (Self) this;
    }

    default Self horizontalTextPosition(int textPosition) {
        getView().setHorizontalTextPosition(textPosition);
        return (Self) this;
    }

    default Self icon(Icon defaultIcon) {
        getView().setIcon(defaultIcon);
        return (Self) this;
    }

    default Self iconTextGap(int iconTextGap) {
        getView().setIconTextGap(iconTextGap);
        return (Self) this;
    }

    default Self layout(LayoutManager mgr) {
        getView().setLayout(mgr);
        return (Self) this;
    }

    default Self margin(Insets m) {
        getView().setMargin(m);
        return (Self) this;
    }

    default Self mnemonic(char mnemonic) {
        getView().setMnemonic(mnemonic);
        return (Self) this;
    }

    default Self mnemonic(int mnemonic) {
        getView().setMnemonic(mnemonic);
        return (Self) this;
    }

    default Self model(ButtonModel newModel) {
        getView().setModel(newModel);
        return (Self) this;
    }

    default Self multiClickThreshhold(long threshhold) {
        getView().setMultiClickThreshhold(threshhold);
        return (Self) this;
    }

    default Self pressedIcon(Icon pressedIcon) {
        getView().setPressedIcon(pressedIcon);
        return (Self) this;
    }

    default Self rolloverEnabled(boolean b) {
        getView().setRolloverEnabled(b);
        return (Self) this;
    }

    default Self rolloverIcon(Icon rolloverIcon) {
        getView().setRolloverIcon(rolloverIcon);
        return (Self) this;
    }

    default Self rolloverSelectedIcon(Icon rolloverSelectedIcon) {
        getView().setRolloverSelectedIcon(rolloverSelectedIcon);
        return (Self) this;
    }

    default Self selected(boolean b) {
        getView().setSelected(b);
        return (Self) this;
    }

    default Self selectedIcon(Icon selectedIcon) {
        getView().setSelectedIcon(selectedIcon);
        return (Self) this;
    }

    default Self text(String text) {
        getView().setText(text);
        return (Self) this;
    }

    default Self uI(ButtonUI ui) {
        getView().setUI(ui);
        return (Self) this;
    }

    default Self verticalAlignment(int alignment) {
        getView().setVerticalAlignment(alignment);
        return (Self) this;
    }

    default Self verticalTextPosition(int textPosition) {
        getView().setVerticalTextPosition(textPosition);
        return (Self) this;
    }
}
