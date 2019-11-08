package org.fluentness.controller.desktop.swing.component;

import org.fluentness.controller.desktop.swing.SwingView;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.util.Locale;
import java.util.Set;

public abstract class AbstractComponentView<Self extends AbstractComponentView, J extends JComponent> implements SwingView<J> {

    public Self actionMap(ActionMap am) {
        getView().setActionMap(am);
        return (Self) this;
    }

    public Self alignmentX(float alignmentX) {
        getView().setAlignmentX(alignmentX);
        return (Self) this;
    }

    public Self alignmentY(float alignmentY) {
        getView().setAlignmentY(alignmentY);
        return (Self) this;
    }

    public Self autoscrolls(boolean autoscrolls) {
        getView().setAutoscrolls(autoscrolls);
        return (Self) this;
    }

    public Self background(Color bg) {
        getView().setBackground(bg);
        return (Self) this;
    }

    public Self border(Border border) {
        getView().setBorder(border);
        return (Self) this;
    }

    public Self componentPopupMenu(JPopupMenu popup) {
        getView().setComponentPopupMenu(popup);
        return (Self) this;
    }

    public Self debugGraphicsOptions(int debugOptions) {
        getView().setDebugGraphicsOptions(debugOptions);
        return (Self) this;
    }

    public Self locale(Locale l) {
        getView().setLocale(l);
        return (Self) this;
    }

    public Self doubleBuffered(boolean aFlag) {
        getView().setDoubleBuffered(aFlag);
        return (Self) this;
    }

    public Self enabled(boolean enabled) {
        getView().setEnabled(enabled);
        return (Self) this;
    }

    public Self focusTraversalKeys(int id, Set<? extends AWTKeyStroke> keystrokes) {
        getView().setFocusTraversalKeys(id, keystrokes);
        return (Self) this;
    }

    public Self font(Font font) {
        getView().setFont(font);
        return (Self) this;
    }

    public Self foreground(Color fg) {
        getView().setForeground(fg);
        return (Self) this;
    }

    public Self inheritsPopupMenu(boolean value) {
        getView().setInheritsPopupMenu(value);
        return (Self) this;
    }

    public Self inputMap(int condition, InputMap map) {
        getView().setInputMap(condition, map);
        return (Self) this;
    }

    public Self inputVerifier(InputVerifier inputVerifier) {
        getView().setInputVerifier(inputVerifier);
        return (Self) this;
    }

    public Self maximumSize(int x, int y) {
        getView().setMaximumSize(new Dimension(x, y));
        return (Self) this;
    }

    public Self minimumSize(int x, int y) {
        getView().setMinimumSize(new Dimension(x, y));
        return (Self) this;
    }

    public Self opaque(boolean isOpaque) {
        getView().setOpaque(isOpaque);
        return (Self) this;
    }

    public Self preferredSize(Dimension preferredSize) {
        getView().setPreferredSize(preferredSize);
        return (Self) this;
    }

    public Self requestFocusEnabled(boolean requestFocusEnabled) {
        getView().setRequestFocusEnabled(requestFocusEnabled);
        return (Self) this;
    }

    public Self toolTipText(String text) {
        getView().setToolTipText(text);
        return (Self) this;
    }

    public Self transferHandler(TransferHandler newHandler) {
        getView().setTransferHandler(newHandler);
        return (Self) this;
    }

    public Self verifyInputWhenFocusTarget(boolean verifyInputWhenFocusTarget) {
        getView().setVerifyInputWhenFocusTarget(verifyInputWhenFocusTarget);
        return (Self) this;
    }

    public Self visible(boolean aFlag) {
        getView().setVisible(aFlag);
        return (Self) this;
    }

}
