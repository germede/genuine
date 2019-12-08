package org.fluentness.controller.desktop.view.component.button.menu;

import javax.swing.*;

public class RadioButtonMenuItemView extends AbstractMenuItemView<RadioButtonMenuItemView, JRadioButtonMenuItem> {

    private final JRadioButtonMenuItem jRadioButtonMenuItem = new JRadioButtonMenuItem();

    public RadioButtonMenuItemView(String text) {
        super(new JRadioButtonMenuItem(text));
    }

}
