package org.fluentness.controller.desktop;

import org.fluentness.controller.desktop.swing.SwingView;
import org.fluentness.controller.desktop.swing.component.*;
import org.fluentness.controller.desktop.swing.component.button.AbstractButtonView;
import org.fluentness.controller.desktop.swing.component.button.ButtonGroupView;
import org.fluentness.controller.desktop.swing.component.button.ButtonView;
import org.fluentness.controller.desktop.swing.component.button.menu.*;
import org.fluentness.controller.desktop.swing.component.button.toggle.CheckBoxView;
import org.fluentness.controller.desktop.swing.component.button.toggle.RadioButtonView;
import org.fluentness.controller.desktop.swing.component.button.toggle.ToggleButtonView;
import org.fluentness.controller.desktop.swing.component.text.TextAreaView;
import org.fluentness.controller.desktop.swing.container.FrameView;

public final class DesktopViewFactory {

    //==== container
    public static FrameView frame(SwingView swingContainer) {
        return new FrameView(swingContainer);
    }


    //==== component
    public static PanelView panel(AbstractComponentView... JComponentBuilders) {
        return new PanelView(JComponentBuilders);
    }

    public static LabelView label(String text) {
        return new LabelView().text(text);
    }

    public static MenuBarView menuBar(MenuView... menus) {
        return new MenuBarView(menus);
    }

    public static ColorChooserView colorChooser() {
        return new ColorChooserView();
    }



    //==== button
    public static ButtonView button(String text) {
        return new ButtonView().text(text);
    }

    public static ButtonGroupView buttonGroup(AbstractButtonView... buttons) {
        return new ButtonGroupView(buttons);
    }

    //======== menu
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

    //======== toggle
    public static ToggleButtonView toggleButton(String text) {
        return new ToggleButtonView().text(text);
    }

    public static RadioButtonView radioButton(String text) {
        return new RadioButtonView().text(text);
    }

    public static CheckBoxView checkBox(String text) {
        return new CheckBoxView().text(text);
    }

    //==== text
    public static TextAreaView textArea() {
        return new TextAreaView();
    }

}
