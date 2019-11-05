package org.fluentness.controller.desktop.swing.component.button;

import javax.swing.*;
import javax.swing.plaf.MenuItemUI;

public class JMenuItemView implements AbstractButtonView<JMenuItemView, JMenuItem> {

    private JMenuItem jMenuItem = new JMenuItem();

    @Override
    public JMenuItem getView() {
        return jMenuItem;
    }

    public JMenuItemView accelerator(KeyStroke keyStroke) {
        jMenuItem.setAccelerator(keyStroke);
        return this;
    }

    public JMenuItemView armed(boolean b) {
        jMenuItem.setArmed(b);
        return this;
    }

    public JMenuItemView enabled(boolean b) {
        jMenuItem.setEnabled(b);
        return this;
    }

    public JMenuItemView model(ButtonModel newModel) {
        jMenuItem.setModel(newModel);
        return this;
    }

    public JMenuItemView uI(MenuItemUI ui) {
        jMenuItem.setUI(ui);
        return this;
    }
}
