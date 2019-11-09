package org.fluentness.controller.desktop.swing.component.button.menu;

import javax.swing.*;

public class MenuView extends AbstractMenuItemView<MenuView, JMenu> {

    private final JMenu jMenu = new JMenu();

    public MenuView(AbstractMenuItemView... menuItems) {
        for (AbstractMenuItemView menuItem : menuItems) {
            jMenu.add(menuItem.getSwingView());
        }
    }

    @Override
    public JMenu getSwingView() {
        return jMenu;
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

}
