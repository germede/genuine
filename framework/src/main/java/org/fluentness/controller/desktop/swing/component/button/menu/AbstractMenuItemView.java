package org.fluentness.controller.desktop.swing.component.button.menu;

import org.fluentness.controller.desktop.swing.component.button.AbstractButtonView;

import javax.swing.*;
import javax.swing.event.MenuDragMouseListener;
import javax.swing.event.MenuKeyListener;
import javax.swing.plaf.MenuItemUI;

public abstract class AbstractMenuItemView<Self extends AbstractMenuItemView, T extends JMenuItem> extends AbstractButtonView<Self, T> {

    @Override
    public abstract T getSwingView();

    public Self accelerator(KeyStroke keyStroke) {
        getSwingView().setAccelerator(keyStroke);
        return (Self) this;
    }

    public Self armed(boolean b) {
        getSwingView().setArmed(b);
        return (Self) this;
    }

    public Self menuDragMouseListener(MenuDragMouseListener l) {
        getSwingView().addMenuDragMouseListener(l);
        return (Self) this;
    }

    public Self menuKeyListener(MenuKeyListener l) {
        getSwingView().addMenuKeyListener(l);
        return (Self) this;
    }

    public Self uI(MenuItemUI ui) {
        getSwingView().setUI(ui);
        return (Self) this;
    }
}
