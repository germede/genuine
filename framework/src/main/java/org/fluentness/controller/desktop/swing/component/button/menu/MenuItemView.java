package org.fluentness.controller.desktop.swing.component.button.menu;

import javax.swing.*;

public class MenuItemView implements AbstractMenuItemView<MenuItemView, JMenuItem> {

    private JMenuItem jMenuItem = new JMenuItem();

    @Override
    public JMenuItem getView() {
        return jMenuItem;
    }

}
