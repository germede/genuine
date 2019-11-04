package org.fluentness.controller.desktop.swing;

import org.fluentness.controller.desktop.swing.button.JMenuBuilder;

import javax.swing.*;
import java.awt.*;

public class JMenuBarBuilder implements JComponentBuilder<JMenuBarBuilder, JMenuBar> {

    private JMenuBar jMenuBar = new JMenuBar();

    public JMenuBarBuilder(JMenuBuilder... menus) {
        for (JMenuBuilder menu : menus) {
            jMenuBar.add(menu.getJComponent());
        }
    }

    @Override
    public JMenuBar getJComponent() {
        return jMenuBar;
    }


    public JMenuBarBuilder borderPainted(boolean b) {
        jMenuBar.setBorderPainted(b);
        return this;
    }

    public JMenuBarBuilder margin(Insets m) {
        jMenuBar.setMargin(m);
        return this;
    }
    public JMenuBarBuilder selected(Component sel) {
        jMenuBar.setSelected(sel);
        return this;
    }
    public JMenuBarBuilder selectionModel(SingleSelectionModel model) {
        jMenuBar.setSelectionModel(model);
        return this;
    }
}
