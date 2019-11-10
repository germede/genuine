package org.fluentness.controller.desktop.swing.component.button.menu;

import javax.swing.*;

public class CheckBoxMenuItemView extends AbstractMenuItemView<CheckBoxMenuItemView, JCheckBoxMenuItem> {

    private final JCheckBoxMenuItem jCheckBoxMenuItem = new JCheckBoxMenuItem();

    public CheckBoxMenuItemView(String text) {
        text(text);
    }

    @Override
    public JCheckBoxMenuItem getSwingView() {
        return jCheckBoxMenuItem;
    }

}
