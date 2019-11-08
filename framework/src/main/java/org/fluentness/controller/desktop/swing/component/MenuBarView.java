package org.fluentness.controller.desktop.swing.component;

import org.fluentness.controller.desktop.swing.component.button.menu.MenuView;

import javax.swing.*;
import java.awt.*;

public class MenuBarView extends AbstractComponentView<MenuBarView, JMenuBar> {

    private JMenuBar jMenuBar = new JMenuBar();

    public MenuBarView(MenuView... menus) {
        for (MenuView menu : menus) {
            jMenuBar.add(menu.getView());
        }
    }

    @Override
    public JMenuBar getView() {
        return jMenuBar;
    }


    public MenuBarView borderPainted(boolean b) {
        jMenuBar.setBorderPainted(b);
        return this;
    }

    public MenuBarView margin(Insets m) {
        jMenuBar.setMargin(m);
        return this;
    }
    public MenuBarView selected(Component sel) {
        jMenuBar.setSelected(sel);
        return this;
    }
    public MenuBarView selectionModel(SingleSelectionModel model) {
        jMenuBar.setSelectionModel(model);
        return this;
    }
}
