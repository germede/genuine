package org.fluentness.controller.desktop.swing.component.button.menu;

import javax.swing.*;
import java.awt.*;

public class MenuView implements AbstractMenuItemView<MenuView, JMenu> {

    private JMenu jMenu = new JMenu();

    public MenuView(AbstractMenuItemView... menuItems) {
        for (AbstractMenuItemView menuItem : menuItems) {
            jMenu.add(menuItem.getView());
        }
    }

    @Override
    public JMenu getView() {
        return jMenu;
    }

    public MenuView componentOrientation(ComponentOrientation componentOrientation) {
        jMenu.setComponentOrientation(componentOrientation);
        return this;
    }

    public MenuView delay(int d) {
        jMenu.setDelay(d);
        return this;
    }

    public MenuView menuLocation(int x, int y) {
        jMenu.setMenuLocation(x, y);
        return this;
    }

    public MenuView popupMenuVisible(boolean b) {
        jMenu.setPopupMenuVisible(b);
        return this;
    }

    public MenuView selected(boolean b) {
        jMenu.setSelected(b);
        return this;
    }

}
