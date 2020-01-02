package org.fluentness.controller.desktop.template;

import org.fluentness.controller.desktop.template.component.*;
import org.fluentness.controller.desktop.template.component.button.AbstractButtonView;
import org.fluentness.controller.desktop.template.component.button.ButtonView;
import org.fluentness.controller.desktop.template.component.button.menu.*;
import org.fluentness.controller.desktop.template.component.button.toggle.CheckBoxView;
import org.fluentness.controller.desktop.template.component.button.toggle.RadioButtonView;
import org.fluentness.controller.desktop.template.component.button.toggle.ToggleButtonView;
import org.fluentness.controller.desktop.template.component.text.TextAreaView;
import org.fluentness.controller.desktop.template.container.DialogView;
import org.fluentness.controller.desktop.template.container.FrameView;
import org.fluentness.controller.desktop.template.container.WindowView;

import javax.swing.*;

public final class SwingViewFactory {

    // ==== container
    public static FrameView frame(DesktopTemplate contentPane) {
        return new FrameView(contentPane);
    }

    public static FrameView frame(String id, DesktopTemplate contentPane) {
        FrameView frameView = new FrameView(contentPane);
        SwingViewRegistry.add(id, frameView.getView());
        return frameView;
    }

    public static WindowView window(DesktopTemplate contentPane) {
        return new WindowView(contentPane);
    }

    public static DialogView dialog(DesktopTemplate contentPane) {
        return new DialogView(contentPane);
    }


    // ==== component
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

    public static PopupMenuView popupMenu(AbstractMenuItemView... menuItems) {
        return new PopupMenuView(menuItems);
    }


    // ======== table
    public static TableView table(String[] header, Object[]... rows) {
        return new TableView(header, rows);
    }

    public static String[] header(String... columnTitles) {
        return columnTitles;
    }

    public static Object[] row(Object... cells) {
        return cells;
    }

    // ======== button
    public static ButtonView button(String text) {
        return new ButtonView(text);
    }

    public static AbstractButtonView[] buttonGroup(AbstractButtonView... buttons) {
        ButtonGroup buttonGroup = new ButtonGroup();
        for (AbstractButtonView button : buttons) {
            buttonGroup.add((AbstractButton) button.view);
        }
        return buttons;
    }

    public static AbstractMenuItemView[] buttonGroupInMenu(AbstractMenuItemView... buttons) {
        ButtonGroup buttonGroup = new ButtonGroup();
        for (AbstractButtonView button : buttons) {
            buttonGroup.add((AbstractButton) button.view);
        }
        return buttons;
    }

    // ============ menu
    public static MenuView menu(String text, AbstractMenuItemView... menuItems) {
        return new MenuView(text, menuItems);
    }

    public static MenuItemView menuItem(String text) {
        return new MenuItemView(text);
    }

    public static RadioButtonMenuItemView radioButtonMenuItem(String text) {
        return new RadioButtonMenuItemView(text);
    }

    public static CheckBoxMenuItemView checkBoxMenuItem(String text) {
        return new CheckBoxMenuItemView(text);
    }

    // ============ toggle
    public static ToggleButtonView toggleButton(String text) {
        return new ToggleButtonView(text);
    }

    public static RadioButtonView radioButton(String text) {
        return new RadioButtonView(text);
    }

    public static CheckBoxView checkBox(String text) {
        return new CheckBoxView(text);
    }

    // ======== text
    public static TextAreaView textArea() {
        return new TextAreaView();
    }

}
