package org.fluentness.controller.desktop.view.component.button.menu;

import javax.swing.*;

public class MenuItemView extends AbstractMenuItemView<MenuItemView, JMenuItem> {

    public MenuItemView(String text) {
        super(new JMenuItem(text));
    }

}
