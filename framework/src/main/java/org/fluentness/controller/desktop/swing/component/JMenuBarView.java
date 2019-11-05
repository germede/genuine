package org.fluentness.controller.desktop.swing.component;

import org.fluentness.controller.desktop.swing.component.button.JMenuView;

import javax.swing.*;
import java.awt.*;

public class JMenuBarView implements JComponentView<JMenuBarView, JMenuBar> {

    private JMenuBar jMenuBar = new JMenuBar();

    public JMenuBarView(JMenuView... menus) {
        for (JMenuView menu : menus) {
            jMenuBar.add(menu.getView());
        }
    }

    @Override
    public JMenuBar getView() {
        return jMenuBar;
    }


    public JMenuBarView borderPainted(boolean b) {
        jMenuBar.setBorderPainted(b);
        return this;
    }

    public JMenuBarView margin(Insets m) {
        jMenuBar.setMargin(m);
        return this;
    }
    public JMenuBarView selected(Component sel) {
        jMenuBar.setSelected(sel);
        return this;
    }
    public JMenuBarView selectionModel(SingleSelectionModel model) {
        jMenuBar.setSelectionModel(model);
        return this;
    }
}
