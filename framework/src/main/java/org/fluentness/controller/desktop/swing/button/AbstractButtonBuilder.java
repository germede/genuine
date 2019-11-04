package org.fluentness.controller.desktop.swing.button;

import org.fluentness.controller.desktop.swing.JComponentBuilder;

import javax.swing.*;
import javax.swing.plaf.ButtonUI;
import java.awt.*;

public interface AbstractButtonBuilder<A extends AbstractButtonBuilder, AB extends AbstractButton>
    extends JComponentBuilder<A, AB> {

    default A action(Action a) {
        getJComponent().setAction(a);
        return (A) this;
    }

    default A actionCommand(String actionCommand) {
        getJComponent().setActionCommand(actionCommand);
        return (A) this;
    }

    default A borderPainted(boolean b) {
        getJComponent().setBorderPainted(b);
        return (A) this;
    }

    default A contentAreaFilled(boolean b) {
        getJComponent().setContentAreaFilled(b);
        return (A) this;
    }

    default A disabledIcon(Icon disabledIcon) {
        getJComponent().setDisabledIcon(disabledIcon);
        return (A) this;
    }

    default A disabledSelectedIcon(Icon disabledSelectedIcon) {
        getJComponent().setDisabledSelectedIcon(disabledSelectedIcon);
        return (A) this;
    }

    default A displayedMnemonicIndex(int index) {
        getJComponent().setDisplayedMnemonicIndex(index);
        return (A) this;
    }

    default A focusPainted(boolean b) {
        getJComponent().setFocusPainted(b);
        return (A) this;
    }

    default A hideActionText(boolean hideActionText) {
        getJComponent().setHideActionText(hideActionText);
        return (A) this;
    }

    default A horizontalAlignment(int alignment) {
        getJComponent().setHorizontalAlignment(alignment);
        return (A) this;
    }

    default A horizontalTextPosition(int textPosition) {
        getJComponent().setHorizontalTextPosition(textPosition);
        return (A) this;
    }

    default A icon(Icon defaultIcon) {
        getJComponent().setIcon(defaultIcon);
        return (A) this;
    }

    default A iconTextGap(int iconTextGap) {
        getJComponent().setIconTextGap(iconTextGap);
        return (A) this;
    }

    default A layout(LayoutManager mgr) {
        getJComponent().setLayout(mgr);
        return (A) this;
    }

    default A margin(Insets m) {
        getJComponent().setMargin(m);
        return (A) this;
    }

    default A mnemonic(char mnemonic) {
        getJComponent().setMnemonic(mnemonic);
        return (A) this;
    }

    default A mnemonic(int mnemonic) {
        getJComponent().setMnemonic(mnemonic);
        return (A) this;
    }

    default A model(ButtonModel newModel) {
        getJComponent().setModel(newModel);
        return (A) this;
    }

    default A multiClickThreshhold(long threshhold) {
        getJComponent().setMultiClickThreshhold(threshhold);
        return (A) this;
    }

    default A pressedIcon(Icon pressedIcon) {
        getJComponent().setPressedIcon(pressedIcon);
        return (A) this;
    }

    default A rolloverEnabled(boolean b) {
        getJComponent().setRolloverEnabled(b);
        return (A) this;
    }

    default A rolloverIcon(Icon rolloverIcon) {
        getJComponent().setRolloverIcon(rolloverIcon);
        return (A) this;
    }

    default A rolloverSelectedIcon(Icon rolloverSelectedIcon) {
        getJComponent().setRolloverSelectedIcon(rolloverSelectedIcon);
        return (A) this;
    }

    default A selected(boolean b) {
        getJComponent().setSelected(b);
        return (A) this;
    }

    default A selectedIcon(Icon selectedIcon) {
        getJComponent().setSelectedIcon(selectedIcon);
        return (A) this;
    }

    default A text(String text) {
        getJComponent().setText(text);
        return (A) this;
    }

    default A uI(ButtonUI ui) {
        getJComponent().setUI(ui);
        return (A) this;
    }

    default A verticalAlignment(int alignment) {
        getJComponent().setVerticalAlignment(alignment);
        return (A) this;
    }

    default A verticalTextPosition(int textPosition) {
        getJComponent().setVerticalTextPosition(textPosition);
        return (A) this;
    }
}
