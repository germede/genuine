package org.fluentness.controller.desktop.swing.container;

import org.fluentness.controller.desktop.swing.AbstractSwingView;

import java.awt.*;

public abstract class AbstractWindowView<Self extends AbstractWindowView, T extends Window> extends AbstractSwingView<Self,T> {

    @Override
    public abstract T getSwingView();

    public Self center() {
        getSwingView().setLocationRelativeTo(null);
        return (Self) this;
    }


    public Self alwaysOnTop(boolean alwaysOnTop) {
        getSwingView().setAlwaysOnTop(alwaysOnTop);
        return (Self) this;
    }

    public Self autoRequestFocus(boolean autoRequestFocus) {
        getSwingView().setAutoRequestFocus(autoRequestFocus);
        return (Self) this;
    }

    public Self focusableWindowState(boolean focusableWindowState) {
        getSwingView().setFocusableWindowState(focusableWindowState);
        return (Self) this;
    }

    public Self iconImage(Image image) {
        getSwingView().setIconImage(image);
        return (Self) this;
    }

    public Self iconImages(java.util.List<? extends Image> icons) {
        getSwingView().setIconImages(icons);
        return (Self) this;
    }

    public Self locationByPlatform(boolean locationByPlatform) {
        getSwingView().setLocationByPlatform(locationByPlatform);
        return (Self) this;
    }

    public Self locationRelativeTo(Component c) {
        getSwingView().setLocationRelativeTo(c);
        return (Self) this;
    }

    public Self modalExclusionType(Dialog.ModalExclusionType exclusionType) {
        getSwingView().setModalExclusionType(exclusionType);
        return (Self) this;
    }

    public Self opacity(float opacity) {
        getSwingView().setOpacity(opacity);
        return (Self) this;
    }

    public Self shape(Shape shape) {
        getSwingView().setShape(shape);
        return (Self) this;
    }

    public Self type(Window.Type type) {
        getSwingView().setType(type);
        return (Self) this;
    }
}
