package org.fluentness.controller.desktop.swing.component.button;

import javax.swing.*;
import javax.swing.plaf.MenuItemUI;

public class JMenuItemBuilder implements AbstractButtonBuilder<JMenuItemBuilder, JMenuItem> {

    private JMenuItem jMenuItem = new JMenuItem();

    @Override
    public JMenuItem getView() {
        return jMenuItem;
    }

    public JMenuItemBuilder	accelerator(KeyStroke keyStroke) {
        jMenuItem.setAccelerator(keyStroke);
        return this;
    }

    public JMenuItemBuilder	armed(boolean b) {
        jMenuItem.setArmed(b);
        return this;
    }

    public JMenuItemBuilder	enabled(boolean b) {
        jMenuItem.setEnabled(b);
        return this;
    }

    public JMenuItemBuilder	model(ButtonModel newModel) {
        jMenuItem.setModel(newModel);
        return this;
    }

    public JMenuItemBuilder	uI(MenuItemUI ui) {
        jMenuItem.setUI(ui);
        return this;
    }
}
