package org.fluentness.controller.desktop.swing.component.button.menu;

import org.fluentness.controller.desktop.swing.component.button.AbstractButtonView;

import javax.swing.*;
import javax.swing.event.MenuDragMouseListener;
import javax.swing.event.MenuKeyListener;
import javax.swing.plaf.MenuItemUI;

public abstract class AbstractMenuItemView<Self extends AbstractMenuItemView, View extends JMenuItem> extends AbstractButtonView<Self, View> {

    public AbstractMenuItemView(View view) {
        super(view);
    }

    public Self accelerator(KeyStroke keyStroke) {
        view.setAccelerator(keyStroke);
        return (Self) this;
    }

    public Self armed(boolean b) {
        view.setArmed(b);
        return (Self) this;
    }

    public Self menuDragMouseListener(MenuDragMouseListener l) {
        view.addMenuDragMouseListener(l);
        return (Self) this;
    }

    public Self menuKeyListener(MenuKeyListener l) {
        view.addMenuKeyListener(l);
        return (Self) this;
    }

    public Self uI(MenuItemUI ui) {
        view.setUI(ui);
        return (Self) this;
    }
}
