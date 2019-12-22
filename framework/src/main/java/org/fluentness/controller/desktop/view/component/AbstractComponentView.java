package org.fluentness.controller.desktop.view.component;

import org.fluentness.controller.desktop.view.AbstractSwingView;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.event.AncestorListener;
import java.beans.VetoableChangeListener;

public abstract class AbstractComponentView<Self extends AbstractComponentView, View extends JComponent> extends AbstractSwingView<Self, View> {

    public AbstractComponentView(View view) {
        super(view);
    }

    public Self ancestorListener(AncestorListener listener) {
        view.addAncestorListener(listener);
        return (Self) this;
    }

    public Self vetoableChangeListener(VetoableChangeListener listener) {
        view.addVetoableChangeListener(listener);
        return (Self) this;
    }

    public Self alignmentX(float alignmentX) {
        view.setAlignmentX(alignmentX);
        return (Self) this;
    }

    public Self alignmentY(float alignmentY) {
        view.setAlignmentY(alignmentY);
        return (Self) this;
    }

    public Self autoscrolls(boolean autoscrolls) {
        view.setAutoscrolls(autoscrolls);
        return (Self) this;
    }

    public Self border(Border border) {
        view.setBorder(border);
        return (Self) this;
    }

    public Self popupMenu(PopupMenuView popup) {
        view.setComponentPopupMenu(popup.view);
        return (Self) this;
    }

    public Self debugGraphicsOptions(int debugOptions) {
        view.setDebugGraphicsOptions(debugOptions);
        return (Self) this;
    }

    public Self doubleBuffered(boolean aFlag) {
        view.setDoubleBuffered(aFlag);
        return (Self) this;
    }

    public Self inheritsPopupMenu(boolean value) {
        view.setInheritsPopupMenu(value);
        return (Self) this;
    }

    public Self inputMap(int condition, InputMap map) {
        view.setInputMap(condition, map);
        return (Self) this;
    }

    public Self inputVerifier(InputVerifier inputVerifier) {
        view.setInputVerifier(inputVerifier);
        return (Self) this;
    }

    public Self opaque(boolean isOpaque) {
        view.setOpaque(isOpaque);
        return (Self) this;
    }

    public Self requestFocusEnabled(boolean requestFocusEnabled) {
        view.setRequestFocusEnabled(requestFocusEnabled);
        return (Self) this;
    }

    public Self toolTipText(String text) {
        view.setToolTipText(text);
        return (Self) this;
    }

    public Self transferHandler(TransferHandler newHandler) {
        view.setTransferHandler(newHandler);
        return (Self) this;
    }

    public Self verifyInputWhenFocusTarget(boolean verifyInputWhenFocusTarget) {
        view.setVerifyInputWhenFocusTarget(verifyInputWhenFocusTarget);
        return (Self) this;
    }

}
