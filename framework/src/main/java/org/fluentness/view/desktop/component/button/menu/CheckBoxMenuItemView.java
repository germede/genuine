package org.fluentness.view.desktop.component.button.menu;

import javax.swing.*;

public class CheckBoxMenuItemView extends AbstractMenuItemView<CheckBoxMenuItemView, JCheckBoxMenuItem> {

    public CheckBoxMenuItemView(String text) {
        super(new JCheckBoxMenuItem(text));
    }

}
