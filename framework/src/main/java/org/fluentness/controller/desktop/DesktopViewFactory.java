package org.fluentness.controller.desktop;

import org.fluentness.controller.desktop.swing.SwingView;
import org.fluentness.controller.desktop.swing.component.ComponentView;
import org.fluentness.controller.desktop.swing.component.LabelView;
import org.fluentness.controller.desktop.swing.component.MenuBarView;
import org.fluentness.controller.desktop.swing.component.PanelView;
import org.fluentness.controller.desktop.swing.component.button.ButtonView;
import org.fluentness.controller.desktop.swing.component.button.menu.*;
import org.fluentness.controller.desktop.swing.component.button.toggle.CheckBoxView;
import org.fluentness.controller.desktop.swing.component.button.toggle.RadioButtonView;
import org.fluentness.controller.desktop.swing.component.button.toggle.ToggleButtonView;
import org.fluentness.controller.desktop.swing.container.JFrameView;

public final class DesktopViewFactory {

    // containers
    public static JFrameView frame(SwingView swingContainer) {
        return new JFrameView(swingContainer);
    }


    // components
    public static PanelView panel(ComponentView... JComponentBuilders) {
        return new PanelView(JComponentBuilders);
    }

    public static LabelView label(String text) {
        return new LabelView().text(text);
    }

    public static MenuBarView menuBar(MenuView... menus) {
        return new MenuBarView(menus);
    }


    // buttons
    public static ButtonView button(String text) {
        return new ButtonView().text(text);
    }

    // menus
    public static MenuView menu(String text, AbstractMenuItemView... menuItems) {
        return new MenuView(menuItems).text(text);
    }

    public static MenuItemView menuItem(String text) {
        return new MenuItemView().text(text);
    }

    public static RadioButtonMenuItemView radioButtonMenuItem(String text) {
        return new RadioButtonMenuItemView().text(text);
    }

    public static CheckBoxMenuItemView checkBoxMenuItem(String text) {
        return new CheckBoxMenuItemView().text(text);
    }

    // toggle
    public static ToggleButtonView toggleButton(String text) {
        return new ToggleButtonView().text(text);
    }

    public static RadioButtonView radioButton(String text) {
        return new RadioButtonView().text(text);
    }

    public static CheckBoxView checkBox(String text) {
        return new CheckBoxView().text(text);
    }


}
