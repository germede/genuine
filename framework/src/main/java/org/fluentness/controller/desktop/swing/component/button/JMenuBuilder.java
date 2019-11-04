package org.fluentness.controller.desktop.swing.component.button;

import javax.swing.*;
import javax.swing.plaf.MenuItemUI;
import java.awt.*;

public class JMenuBuilder implements AbstractButtonBuilder<JMenuBuilder, JMenu> {

    private JMenu jMenu = new JMenu();

    public JMenuBuilder(JMenuItemBuilder... menuItems) {
        for (JMenuItemBuilder menuItem : menuItems) {
            jMenu.add(menuItem.getView());
        }
    }

    @Override
    public JMenu getView() {
        return jMenu;
    }

    public JMenuBuilder accelerator(KeyStroke keyStroke) {
        jMenu.setAccelerator(keyStroke);
        return this;
    }

    public JMenuBuilder	armed(boolean b) {
        jMenu.setArmed(b);
        return this;
    }

    public JMenuBuilder componentOrientation(ComponentOrientation componentOrientation) {
        jMenu.setComponentOrientation(componentOrientation);
        return this;
    }

    public JMenuBuilder delay(int d) {
        jMenu.setDelay(d);
        return this;
    }

    public JMenuBuilder	enabled(boolean b) {
        jMenu.setEnabled(b);
        return this;
    }

    public JMenuBuilder menuLocation(int x, int y) {
        jMenu.setMenuLocation(x, y);
        return this;
    }

    public JMenuBuilder model(ButtonModel newModel) {
        jMenu.setModel(newModel);
        return this;
    }

    public JMenuBuilder popupMenuVisible(boolean b) {
        jMenu.setPopupMenuVisible(b);
        return this;
    }

    public JMenuBuilder selected(boolean b) {
        jMenu.setSelected(b);
        return this;
    }

    public JMenuBuilder	uI(MenuItemUI ui) {
        jMenu.setUI(ui);
        return this;
    }

}
