package org.fluentness.controller.desktop.swing.component.button;

import javax.swing.*;
import javax.swing.plaf.MenuItemUI;

public class MenuItemView implements AbstractButtonView<MenuItemView, JMenuItem> {

    private JMenuItem jMenuItem = new JMenuItem();

    @Override
    public JMenuItem getView() {
        return jMenuItem;
    }

    public MenuItemView accelerator(KeyStroke keyStroke) {
        jMenuItem.setAccelerator(keyStroke);
        return this;
    }

    public MenuItemView armed(boolean b) {
        jMenuItem.setArmed(b);
        return this;
    }

    public MenuItemView enabled(boolean b) {
        jMenuItem.setEnabled(b);
        return this;
    }

    public MenuItemView model(ButtonModel newModel) {
        jMenuItem.setModel(newModel);
        return this;
    }

    public MenuItemView uI(MenuItemUI ui) {
        jMenuItem.setUI(ui);
        return this;
    }
}
