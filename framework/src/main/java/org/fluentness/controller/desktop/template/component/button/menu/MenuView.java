package org.fluentness.controller.desktop.template.component.button.menu;

import javax.swing.*;

public class MenuView extends AbstractMenuItemView<MenuView, JMenu> {

    public MenuView(String text, AbstractMenuItemView... menuItems) {
        super(new JMenu(text));
        for (AbstractMenuItemView menuItem : menuItems) {
            view.add(menuItem.getView());
        }
    }

    public MenuView delay(int d) {
        view.setDelay(d);
        return this;
    }

    public MenuView menuLocation(int x, int y) {
        view.setMenuLocation(x, y);
        return this;
    }

    public MenuView popupMenuVisible(boolean b) {
        view.setPopupMenuVisible(b);
        return this;
    }

}
