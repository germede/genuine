package org.fluentness.controller.desktop.swing.component.button.menu;

import org.fluentness.controller.desktop.swing.component.button.AbstractButtonView;

import javax.swing.*;
import javax.swing.plaf.MenuItemUI;

public interface AbstractMenuItemView<Self extends AbstractMenuItemView, M extends JMenuItem> extends AbstractButtonView<Self, M> {

    default Self accelerator(KeyStroke keyStroke) {
        getView().setAccelerator(keyStroke);
        return (Self) this;
    }

    default Self armed(boolean b) {
        getView().setArmed(b);
        return (Self) this;
    }

    default Self enabled(boolean b) {
        getView().setEnabled(b);
        return (Self) this;
    }

    default Self model(ButtonModel newModel) {
        getView().setModel(newModel);
        return (Self) this;
    }

    default Self uI(MenuItemUI ui) {
        getView().setUI(ui);
        return (Self) this;
    }
}
