package com.sample.controller;

import com.bulenkov.darcula.DarculaLaf;
import org.fluentness.controller.desktop.DesktopStyleBuilder;
import org.fluentness.controller.desktop.DesktopView;
import org.fluentness.controller.desktop.DesktopViewHolder;
import org.fluentness.controller.desktop.swing.component.MenuBarView;
import org.fluentness.controller.desktop.swing.component.PopupMenuView;
import org.fluentness.controller.desktop.swing.component.button.menu.MenuItemView;

import javax.swing.*;
import java.awt.*;

import static org.fluentness.controller.desktop.swing.SwingViewFactory.*;

public class Desktop implements DesktopViewHolder {

    private DesktopController desktopController;

    Desktop(DesktopController desktopController) {
        this.desktopController = desktopController;
    }

    @Override
    public void setLookAndFeel() {
        // Set custom look and feel instead of default system one
        try {
            UIManager.put("swing.boldMetal", Boolean.FALSE);
            UIManager.setLookAndFeel(new DarculaLaf());
        } catch (UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void setGlobalStyles(DesktopStyleBuilder styles) {
        styles
            .set(MenuItemView.class, menuItemView -> {
                    menuItemView.border(BorderFactory.createLineBorder(new Color(237, 78, 0)));
                    menuItemView.margin(new Insets(20,20,20,20));
                    menuItemView.text("1234");
                }
            )
        ;
    }

    @Override
    public DesktopView getMainView() {
        return frame(
            panel(
                panel(
                    colorChooser(),

                    table(
                        header("Spalte1", "Spalte2", "Spalte3", "Spalte4"),
                        row(1, "John", 40.0, false),
                        row(2, "Rambo", 70.0, false),
                        row(2, "Rambo", 70.0, false),
                        row(2, "Rambo", 70.0, false),
                        row(2, "Rambo", 70.0, false),
                        row(2, "Rambo", 70.0, false),
                        row(2, "Rambo", 70.0, false),
                        row(3, "Zorro", 60.0, true)
                    ),
                    button("Test button")
                ).flowLayout()
            ).borderLayout(BorderLayout.NORTH, BorderLayout.SOUTH)
        ).title("Fluentness rocks").bounds(0, 0, 800, 600).center().minimumSize(300, 300).menuBar(topBar());
    }

    private MenuBarView topBar() {
        new PopupMenuView().label("asf").getSwingView().setVisible(true);
        return menuBar(
            menu("File",
                menuItem("Load").accelerator(KeyStroke.getKeyStroke('C')),
                menuItem("Save"),
                menuItem("Close")
            ).mnemonic('F'),
            menu("Edit",
                menuItem("Cut").actionListener(desktopController::cutPresed),
                menuItem("Copy"),
                menuItem("Paste")
            ).mnemonic('E'),
            menu("RadioButtons",
                buttonGroupInMenu(
                    radioButtonMenuItem("Radio 1"),
                    radioButtonMenuItem("Radio 2")
                )
            ).mnemonic('R'),
            menu("CheckBoxes",
                checkBoxMenuItem("CheckBox 1"),
                checkBoxMenuItem("CheckBox 2")
            ).mnemonic('C'),
            menu("Help",
                menuItem("Manual"),
                menuItem("About")
            )
        );
    }

}
