package org.fluentness.controller.desktop.swing.component;

import org.fluentness.controller.desktop.swing.SwingBuilder;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

public interface JComponentBuilder<Self extends JComponentBuilder, J extends JComponent> extends SwingBuilder<J> {

    @Override
    default void render() {
        getView().setVisible(true);
    }

    default Self actionMap(ActionMap am) {
        getView().setActionMap(am);
        return (Self) this;
    }

    default Self alignmentX(float alignmentX) {
        getView().setAlignmentX(alignmentX);
        return (Self) this;
    }

    default Self alignmentY(float alignmentY) {
        getView().setAlignmentY(alignmentY);
        return (Self) this;
    }

    default Self autoscrolls(boolean autoscrolls) {
        getView().setAutoscrolls(autoscrolls);
        return (Self) this;
    }

    default Self background(Color bg) {
        getView().setBackground(bg);
        return (Self) this;
    }

    default Self border(Border border) {
        getView().setBorder(border);
        return (Self) this;
    }

    default Self componentPopupMenu(JPopupMenu popup) {
        getView().setComponentPopupMenu(popup);
        return (Self) this;
    }

    default Self debugGraphicsOptions(int debugOptions) {
        getView().setDebugGraphicsOptions(debugOptions);
        return (Self) this;
    }

    default Self locale(Locale l) {
        getView().setLocale(l);
        return (Self) this;
    }

    default Self doubleBuffered(boolean aFlag) {
        getView().setDoubleBuffered(aFlag);
        return (Self) this;
    }

    default Self enabled(boolean enabled) {
        getView().setEnabled(enabled);
        return (Self) this;
    }

    default Self focusTraversalKeys(int id, Set<? extends AWTKeyStroke> keystrokes) {
        getView().setFocusTraversalKeys(id, keystrokes);
        return (Self) this;
    }

    default Self font(Font font) {
        getView().setFont(font);
        return (Self) this;
    }

    default Self foreground(Color fg) {
        getView().setForeground(fg);
        return (Self) this;
    }

    default Self inheritsPopupMenu(boolean value) {
        getView().setInheritsPopupMenu(value);
        return (Self) this;
    }

    default Self inputMap(int condition, InputMap map) {
        getView().setInputMap(condition, map);
        return (Self) this;
    }

    default Self inputVerifier(InputVerifier inputVerifier) {
        getView().setInputVerifier(inputVerifier);
        return (Self) this;
    }

    default Self maximumSize(int x, int y) {
        getView().setMaximumSize(new Dimension(x, y));
        return (Self) this;
    }

    default Self minimumSize(int x, int y) {
        getView().setMinimumSize(new Dimension(x, y));
        return (Self) this;
    }

    default Self opaque(boolean isOpaque) {
        getView().setOpaque(isOpaque);
        return (Self) this;
    }

    default Self preferredSize(Dimension preferredSize) {
        getView().setPreferredSize(preferredSize);
        return (Self) this;
    }

    default Self requestFocusEnabled(boolean requestFocusEnabled) {
        getView().setRequestFocusEnabled(requestFocusEnabled);
        return (Self) this;
    }

    default Self toolTipText(String text) {
        getView().setToolTipText(text);
        return (Self) this;
    }

    default Self transferHandler(TransferHandler newHandler) {
        getView().setTransferHandler(newHandler);
        return (Self) this;
    }

    default Self verifyInputWhenFocusTarget(boolean verifyInputWhenFocusTarget) {
        getView().setVerifyInputWhenFocusTarget(verifyInputWhenFocusTarget);
        return (Self) this;
    }

    default Self visible(boolean aFlag) {
        getView().setVisible(aFlag);
        return (Self) this;
    }

}
