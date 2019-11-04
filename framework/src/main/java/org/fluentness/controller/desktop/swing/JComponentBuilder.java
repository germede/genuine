package org.fluentness.controller.desktop.swing;

import org.fluentness.controller.desktop.DesktopView;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.util.Locale;
import java.util.Set;

public interface JComponentBuilder<Self extends JComponentBuilder, J extends JComponent> extends DesktopView {
    J getJComponent();

    @Override
    default void render() {
        getJComponent().setVisible(true);
    }

    default Self actionMap(ActionMap am) {
        getJComponent().setActionMap(am);
        return (Self) this;
    }

    default Self alignmentX(float alignmentX) {
        getJComponent().setAlignmentX(alignmentX);
        return (Self) this;
    }

    default Self alignmentY(float alignmentY) {
        getJComponent().setAlignmentY(alignmentY);
        return (Self) this;
    }

    default Self autoscrolls(boolean autoscrolls) {
        getJComponent().setAutoscrolls(autoscrolls);
        return (Self) this;
    }

    default Self background(Color bg) {
        getJComponent().setBackground(bg);
        return (Self) this;
    }

    default Self border(Border border) {
        getJComponent().setBorder(border);
        return (Self) this;
    }

    default Self componentPopupMenu(JPopupMenu popup) {
        getJComponent().setComponentPopupMenu(popup);
        return (Self) this;
    }

    default Self debugGraphicsOptions(int debugOptions) {
        getJComponent().setDebugGraphicsOptions(debugOptions);
        return (Self) this;
    }

    default Self locale(Locale l) {
        getJComponent().setLocale(l);
        return (Self) this;
    }

    default Self doubleBuffered(boolean aFlag) {
        getJComponent().setDoubleBuffered(aFlag);
        return (Self) this;
    }

    default Self enabled(boolean enabled) {
        getJComponent().setEnabled(enabled);
        return (Self) this;
    }

    default Self focusTraversalKeys(int id, Set<? extends AWTKeyStroke> keystrokes) {
        getJComponent().setFocusTraversalKeys(id, keystrokes);
        return (Self) this;
    }

    default Self font(Font font) {
        getJComponent().setFont(font);
        return (Self) this;
    }

    default Self foreground(Color fg) {
        getJComponent().setForeground(fg);
        return (Self) this;
    }

    default Self inheritsPopupMenu(boolean value) {
        getJComponent().setInheritsPopupMenu(value);
        return (Self) this;
    }

    default Self inputMap(int condition, InputMap map) {
        getJComponent().setInputMap(condition, map);
        return (Self) this;
    }

    default Self inputVerifier(InputVerifier inputVerifier) {
        getJComponent().setInputVerifier(inputVerifier);
        return (Self) this;
    }

    default Self maximumSize(int x, int y) {
        getJComponent().setMaximumSize(new Dimension(x, y));
        return (Self) this;
    }

    default Self minimumSize(int x, int y) {
        getJComponent().setMinimumSize(new Dimension(x, y));
        return (Self) this;
    }

    default Self opaque(boolean isOpaque) {
        getJComponent().setOpaque(isOpaque);
        return (Self) this;
    }

    default Self preferredSize(Dimension preferredSize) {
        getJComponent().setPreferredSize(preferredSize);
        return (Self) this;
    }

    default Self requestFocusEnabled(boolean requestFocusEnabled) {
        getJComponent().setRequestFocusEnabled(requestFocusEnabled);
        return (Self) this;
    }

    default Self toolTipText(String text) {
        getJComponent().setToolTipText(text);
        return (Self) this;
    }

    default Self transferHandler(TransferHandler newHandler) {
        getJComponent().setTransferHandler(newHandler);
        return (Self) this;
    }

    default Self verifyInputWhenFocusTarget(boolean verifyInputWhenFocusTarget) {
        getJComponent().setVerifyInputWhenFocusTarget(verifyInputWhenFocusTarget);
        return (Self) this;
    }

    default Self visible(boolean aFlag) {
        getJComponent().setVisible(aFlag);
        return (Self) this;
    }

}
