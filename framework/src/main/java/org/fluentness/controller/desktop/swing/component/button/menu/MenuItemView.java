package org.fluentness.controller.desktop.swing.component.button.menu;

import javax.swing.*;

public class MenuItemView extends AbstractMenuItemView<MenuItemView, JMenuItem> {

    private final JMenuItem jMenuItem = new JMenuItem();

    public MenuItemView(String text) {
        text(text);
    }

    @Override
    public JMenuItem getSwingView() {
        return jMenuItem;
    }

}
