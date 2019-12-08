package org.fluentness.controller.desktop.view.component;

import org.fluentness.controller.desktop.view.component.button.menu.MenuView;

import javax.swing.*;
import java.awt.*;

public class MenuBarView extends AbstractComponentView<MenuBarView, JMenuBar> {

    public MenuBarView(MenuView... menus) {
        super(new JMenuBar());
        for (MenuView menu : menus) {
            view.add(menu.getView());
        }
    }

    public MenuBarView borderPainted(boolean b) {
        view.setBorderPainted(b);
        return this;
    }

    public MenuBarView margin(Insets m) {
        view.setMargin(m);
        return this;
    }

    public MenuBarView selected(Component sel) {
        view.setSelected(sel);
        return this;
    }
}
