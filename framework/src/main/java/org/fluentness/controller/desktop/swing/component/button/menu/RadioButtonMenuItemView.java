package org.fluentness.controller.desktop.swing.component.button.menu;

import javax.swing.*;

public class RadioButtonMenuItemView extends AbstractMenuItemView<RadioButtonMenuItemView, JRadioButtonMenuItem> {

    private final JRadioButtonMenuItem jRadioButtonMenuItem = new JRadioButtonMenuItem();

    public RadioButtonMenuItemView(String text) {
        text(text);
    }

    @Override
    public JRadioButtonMenuItem getSwingView() {
        return jRadioButtonMenuItem;
    }

}
