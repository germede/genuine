package org.fluentness.controller.desktop.swing.component.button;

import javax.swing.*;
import javax.swing.plaf.MenuItemUI;
import java.awt.*;

public class JMenuView implements AbstractButtonView<JMenuView, JMenu> {

    private JMenu jMenu = new JMenu();

    public JMenuView(JMenuItemView... menuItems) {
        for (JMenuItemView menuItem : menuItems) {
            jMenu.add(menuItem.getView());
        }
    }

    @Override
    public JMenu getView() {
        return jMenu;
    }

    public JMenuView accelerator(KeyStroke keyStroke) {
        jMenu.setAccelerator(keyStroke);
        return this;
    }

    public JMenuView armed(boolean b) {
        jMenu.setArmed(b);
        return this;
    }

    public JMenuView componentOrientation(ComponentOrientation componentOrientation) {
        jMenu.setComponentOrientation(componentOrientation);
        return this;
    }

    public JMenuView delay(int d) {
        jMenu.setDelay(d);
        return this;
    }

    public JMenuView enabled(boolean b) {
        jMenu.setEnabled(b);
        return this;
    }

    public JMenuView menuLocation(int x, int y) {
        jMenu.setMenuLocation(x, y);
        return this;
    }

    public JMenuView model(ButtonModel newModel) {
        jMenu.setModel(newModel);
        return this;
    }

    public JMenuView popupMenuVisible(boolean b) {
        jMenu.setPopupMenuVisible(b);
        return this;
    }

    public JMenuView selected(boolean b) {
        jMenu.setSelected(b);
        return this;
    }

    public JMenuView uI(MenuItemUI ui) {
        jMenu.setUI(ui);
        return this;
    }

}
