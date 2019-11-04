package org.fluentness.controller.desktop.swing.component.button;

import org.fluentness.controller.desktop.swing.component.JComponentBuilder;

import javax.swing.*;
import javax.swing.plaf.ButtonUI;
import java.awt.*;

public interface AbstractButtonBuilder<A extends AbstractButtonBuilder, AB extends AbstractButton>
    extends JComponentBuilder<A, AB> {

    default A action(Action a) {
        getView().setAction(a);
        return (A) this;
    }

    default A actionCommand(String actionCommand) {
        getView().setActionCommand(actionCommand);
        return (A) this;
    }

    default A borderPainted(boolean b) {
        getView().setBorderPainted(b);
        return (A) this;
    }

    default A contentAreaFilled(boolean b) {
        getView().setContentAreaFilled(b);
        return (A) this;
    }

    default A disabledIcon(Icon disabledIcon) {
        getView().setDisabledIcon(disabledIcon);
        return (A) this;
    }

    default A disabledSelectedIcon(Icon disabledSelectedIcon) {
        getView().setDisabledSelectedIcon(disabledSelectedIcon);
        return (A) this;
    }

    default A displayedMnemonicIndex(int index) {
        getView().setDisplayedMnemonicIndex(index);
        return (A) this;
    }

    default A focusPainted(boolean b) {
        getView().setFocusPainted(b);
        return (A) this;
    }

    default A hideActionText(boolean hideActionText) {
        getView().setHideActionText(hideActionText);
        return (A) this;
    }

    default A horizontalAlignment(int alignment) {
        getView().setHorizontalAlignment(alignment);
        return (A) this;
    }

    default A horizontalTextPosition(int textPosition) {
        getView().setHorizontalTextPosition(textPosition);
        return (A) this;
    }

    default A icon(Icon defaultIcon) {
        getView().setIcon(defaultIcon);
        return (A) this;
    }

    default A iconTextGap(int iconTextGap) {
        getView().setIconTextGap(iconTextGap);
        return (A) this;
    }

    default A layout(LayoutManager mgr) {
        getView().setLayout(mgr);
        return (A) this;
    }

    default A margin(Insets m) {
        getView().setMargin(m);
        return (A) this;
    }

    default A mnemonic(char mnemonic) {
        getView().setMnemonic(mnemonic);
        return (A) this;
    }

    default A mnemonic(int mnemonic) {
        getView().setMnemonic(mnemonic);
        return (A) this;
    }

    default A model(ButtonModel newModel) {
        getView().setModel(newModel);
        return (A) this;
    }

    default A multiClickThreshhold(long threshhold) {
        getView().setMultiClickThreshhold(threshhold);
        return (A) this;
    }

    default A pressedIcon(Icon pressedIcon) {
        getView().setPressedIcon(pressedIcon);
        return (A) this;
    }

    default A rolloverEnabled(boolean b) {
        getView().setRolloverEnabled(b);
        return (A) this;
    }

    default A rolloverIcon(Icon rolloverIcon) {
        getView().setRolloverIcon(rolloverIcon);
        return (A) this;
    }

    default A rolloverSelectedIcon(Icon rolloverSelectedIcon) {
        getView().setRolloverSelectedIcon(rolloverSelectedIcon);
        return (A) this;
    }

    default A selected(boolean b) {
        getView().setSelected(b);
        return (A) this;
    }

    default A selectedIcon(Icon selectedIcon) {
        getView().setSelectedIcon(selectedIcon);
        return (A) this;
    }

    default A text(String text) {
        getView().setText(text);
        return (A) this;
    }

    default A uI(ButtonUI ui) {
        getView().setUI(ui);
        return (A) this;
    }

    default A verticalAlignment(int alignment) {
        getView().setVerticalAlignment(alignment);
        return (A) this;
    }

    default A verticalTextPosition(int textPosition) {
        getView().setVerticalTextPosition(textPosition);
        return (A) this;
    }
}
