package org.fluentness.controller.desktop.swing.component.button.menu;

import org.fluentness.controller.desktop.swing.component.button.AbstractButtonView;

import javax.swing.*;
import javax.swing.plaf.MenuItemUI;

public abstract class AbstractMenuItemView<Self extends AbstractMenuItemView, T extends JMenuItem> extends AbstractButtonView<Self, T> {

    @Override
    public abstract T getView();

    public Self accelerator(KeyStroke keyStroke) {
        getView().setAccelerator(keyStroke);
        return (Self) this;
    }

    public Self armed(boolean b) {
        getView().setArmed(b);
        return (Self) this;
    }

    public Self enabled(boolean b) {
        getView().setEnabled(b);
        return (Self) this;
    }

    public Self model(ButtonModel newModel) {
        getView().setModel(newModel);
        return (Self) this;
    }

    public Self uI(MenuItemUI ui) {
        getView().setUI(ui);
        return (Self) this;
    }
}
