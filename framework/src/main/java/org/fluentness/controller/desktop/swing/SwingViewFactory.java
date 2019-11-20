package org.fluentness.controller.desktop.swing;

import org.fluentness.controller.desktop.swing.component.*;
import org.fluentness.controller.desktop.swing.component.button.AbstractButtonView;
import org.fluentness.controller.desktop.swing.component.button.ButtonView;
import org.fluentness.controller.desktop.swing.component.button.menu.*;
import org.fluentness.controller.desktop.swing.component.button.toggle.CheckBoxView;
import org.fluentness.controller.desktop.swing.component.button.toggle.RadioButtonView;
import org.fluentness.controller.desktop.swing.component.button.toggle.ToggleButtonView;
import org.fluentness.controller.desktop.swing.component.text.TextAreaView;
import org.fluentness.controller.desktop.swing.container.DialogView;
import org.fluentness.controller.desktop.swing.container.FrameView;
import org.fluentness.controller.desktop.swing.container.WindowView;

import javax.swing.*;
import java.awt.*;

public final class SwingViewFactory {
    // default styles
    // todo make default styles as function in controller:
    // public abstract getGlobalStyles () {
    //      add(ButtonView.class, buttonView -> buttonView.setPreferredSize(30,30))
    //      add(LabelView.class, labelView -> set
    public static int DEFAULT_MENU_ITEM_WIDTH = 50;
    public static int DEFAULT_MENU_ITEM_HEIGHT = 30;
    public static Color DEFAULT_MENU_ITEM_BACKGROUND = new Color(48, 48, 48);


    // ==== container
    public static FrameView frame(AbstractSwingView contentPane) {
        return new FrameView(contentPane);
    }

    public static WindowView window(AbstractSwingView contentPane) {
        return new WindowView(contentPane);
    }

    public static DialogView dialog(AbstractSwingView contentPane) {
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
        return new MenuBarView(menus).background(new Color(48, 48, 48));
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
        return new ButtonView().text(text);
    }

    public static AbstractButtonView[] buttonGroup(AbstractButtonView... buttons) {
        ButtonGroup buttonGroup = new ButtonGroup();
        for (AbstractButtonView button : buttons) {
            buttonGroup.add(button.getSwingView());
        }
        return buttons;
    }

    public static AbstractMenuItemView[] buttonGroupInMenu(AbstractMenuItemView... buttons) {
        ButtonGroup buttonGroup = new ButtonGroup();
        for (AbstractButtonView button : buttons) {
            buttonGroup.add(button.getSwingView());
        }
        return buttons;
    }

    // ============ menu
    public static MenuView menu(String text, AbstractMenuItemView... menuItems) {
        return new MenuView(text, menuItems)
            .background(DEFAULT_MENU_ITEM_BACKGROUND)
            .preferredSize(DEFAULT_MENU_ITEM_WIDTH, DEFAULT_MENU_ITEM_HEIGHT);
    }

    public static MenuItemView menuItem(String text) {
        return new MenuItemView(text)
            .background(DEFAULT_MENU_ITEM_BACKGROUND)
            .preferredSize(DEFAULT_MENU_ITEM_WIDTH, DEFAULT_MENU_ITEM_HEIGHT);
    }

    public static RadioButtonMenuItemView radioButtonMenuItem(String text) {
        return new RadioButtonMenuItemView(text)
            .background(DEFAULT_MENU_ITEM_BACKGROUND)
            .preferredSize(DEFAULT_MENU_ITEM_WIDTH, DEFAULT_MENU_ITEM_HEIGHT);
    }

    public static CheckBoxMenuItemView checkBoxMenuItem(String text) {
        return new CheckBoxMenuItemView(text)
            .background(DEFAULT_MENU_ITEM_BACKGROUND)
            .preferredSize(DEFAULT_MENU_ITEM_WIDTH, DEFAULT_MENU_ITEM_HEIGHT);
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
