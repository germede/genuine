package org.fluentness.controller.desktop.swing.component;

import org.fluentness.controller.desktop.swing.AbstractSwingView;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.event.AncestorListener;
import java.beans.VetoableChangeListener;

public abstract class AbstractComponentView<Self extends AbstractComponentView, T extends JComponent> extends AbstractSwingView<Self, T> {

    protected AbstractComponentView(Class<Self> selfClass) {
        super(selfClass);
    }

    @Override
    public abstract T getSwingView();

    public Self ancestorListener(AncestorListener listener) {
        getSwingView().addAncestorListener(listener);
        return (Self) this;
    }

    public Self vetoableChangeListener(VetoableChangeListener listener) {
        getSwingView().addVetoableChangeListener(listener);
        return (Self) this;
    }

    public Self alignmentX(float alignmentX) {
        getSwingView().setAlignmentX(alignmentX);
        return (Self) this;
    }

    public Self alignmentY(float alignmentY) {
        getSwingView().setAlignmentY(alignmentY);
        return (Self) this;
    }

    public Self autoscrolls(boolean autoscrolls) {
        getSwingView().setAutoscrolls(autoscrolls);
        return (Self) this;
    }

    public Self border(Border border) {
        getSwingView().setBorder(border);
        return (Self) this;
    }

    public Self popupMenu(PopupMenuView popup) {
        getSwingView().setComponentPopupMenu(popup.getSwingView());
        return (Self) this;
    }

    public Self debugGraphicsOptions(int debugOptions) {
        getSwingView().setDebugGraphicsOptions(debugOptions);
        return (Self) this;
    }

    public Self doubleBuffered(boolean aFlag) {
        getSwingView().setDoubleBuffered(aFlag);
        return (Self) this;
    }

    public Self inheritsPopupMenu(boolean value) {
        getSwingView().setInheritsPopupMenu(value);
        return (Self) this;
    }

    public Self inputMap(int condition, InputMap map) {
        getSwingView().setInputMap(condition, map);
        return (Self) this;
    }

    public Self inputVerifier(InputVerifier inputVerifier) {
        getSwingView().setInputVerifier(inputVerifier);
        return (Self) this;
    }

    public Self opaque(boolean isOpaque) {
        getSwingView().setOpaque(isOpaque);
        return (Self) this;
    }

    public Self requestFocusEnabled(boolean requestFocusEnabled) {
        getSwingView().setRequestFocusEnabled(requestFocusEnabled);
        return (Self) this;
    }

    public Self toolTipText(String text) {
        getSwingView().setToolTipText(text);
        return (Self) this;
    }

    public Self transferHandler(TransferHandler newHandler) {
        getSwingView().setTransferHandler(newHandler);
        return (Self) this;
    }

    public Self verifyInputWhenFocusTarget(boolean verifyInputWhenFocusTarget) {
        getSwingView().setVerifyInputWhenFocusTarget(verifyInputWhenFocusTarget);
        return (Self) this;
    }

}
