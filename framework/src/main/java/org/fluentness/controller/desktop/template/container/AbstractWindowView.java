package org.fluentness.controller.desktop.template.container;

import org.fluentness.controller.desktop.template.DesktopTemplate;

import java.awt.*;

public abstract class AbstractWindowView<Self extends AbstractWindowView, View extends Window> extends DesktopTemplate<Self, View> {

    protected AbstractWindowView(View view) {
        super(view);
    }

    public Self center() {
        view.setLocationRelativeTo(null);
        return (Self) this;
    }


    public Self alwaysOnTop(boolean alwaysOnTop) {
        view.setAlwaysOnTop(alwaysOnTop);
        return (Self) this;
    }

    public Self autoRequestFocus(boolean autoRequestFocus) {
        view.setAutoRequestFocus(autoRequestFocus);
        return (Self) this;
    }

    public Self focusableWindowState(boolean focusableWindowState) {
        view.setFocusableWindowState(focusableWindowState);
        return (Self) this;
    }

    public Self iconImage(Image image) {
        view.setIconImage(image);
        return (Self) this;
    }

    public Self iconImages(java.util.List<? extends Image> icons) {
        view.setIconImages(icons);
        return (Self) this;
    }

    public Self locationByPlatform(boolean locationByPlatform) {
        view.setLocationByPlatform(locationByPlatform);
        return (Self) this;
    }

    public Self locationRelativeTo(Component c) {
        view.setLocationRelativeTo(c);
        return (Self) this;
    }

    public Self modalExclusionType(Dialog.ModalExclusionType exclusionType) {
        view.setModalExclusionType(exclusionType);
        return (Self) this;
    }

    public Self opacity(float opacity) {
        view.setOpacity(opacity);
        return (Self) this;
    }

    public Self shape(Shape shape) {
        view.setShape(shape);
        return (Self) this;
    }

    public Self type(Window.Type type) {
        view.setType(type);
        return (Self) this;
    }
}
