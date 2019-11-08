package org.fluentness.controller.desktop.swing.component.button.menu;

import javax.swing.*;

public class CheckBoxMenuItemView extends AbstractMenuItemView<CheckBoxMenuItemView, JCheckBoxMenuItem> {

    private JCheckBoxMenuItem jCheckBoxMenuItem = new JCheckBoxMenuItem();

    @Override
    public JCheckBoxMenuItem getSwingView() {
        return jCheckBoxMenuItem;
    }

}
