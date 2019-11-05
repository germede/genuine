package org.fluentness.controller.desktop.swing.component.button;

import javax.swing.*;
import javax.swing.plaf.MenuItemUI;
import java.awt.*;

public class MenuView implements AbstractButtonView<MenuView, JMenu> {

    private JMenu jMenu = new JMenu();

    public MenuView(MenuItemView... menuItems) {
        for (MenuItemView menuItem : menuItems) {
            jMenu.add(menuItem.getView());
        }
    }

    @Override
    public JMenu getView() {
        return jMenu;
    }

    public MenuView accelerator(KeyStroke keyStroke) {
        jMenu.setAccelerator(keyStroke);
        return this;
    }

    public MenuView armed(boolean b) {
        jMenu.setArmed(b);
        return this;
    }

    public MenuView componentOrientation(ComponentOrientation componentOrientation) {
        jMenu.setComponentOrientation(componentOrientation);
        return this;
    }

    public MenuView delay(int d) {
        jMenu.setDelay(d);
        return this;
    }

    public MenuView enabled(boolean b) {
        jMenu.setEnabled(b);
        return this;
    }

    public MenuView menuLocation(int x, int y) {
        jMenu.setMenuLocation(x, y);
        return this;
    }

    public MenuView model(ButtonModel newModel) {
        jMenu.setModel(newModel);
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

    public MenuView uI(MenuItemUI ui) {
        jMenu.setUI(ui);
        return this;
    }

}
