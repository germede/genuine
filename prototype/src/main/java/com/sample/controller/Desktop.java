package com.sample.controller;

import org.fluentness.controller.desktop.DesktopStyle;
import org.fluentness.controller.desktop.DesktopView;
import org.fluentness.controller.desktop.DesktopViewHolder;
import org.fluentness.controller.desktop.swing.component.MenuBarView;

import javax.swing.*;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;
import java.awt.*;

import static org.fluentness.controller.desktop.DesktopStyleFactory.style;
import static org.fluentness.controller.desktop.swing.SwingViewFactory.*;

public class Desktop implements DesktopViewHolder {

    private DesktopController desktopController;

    Desktop(DesktopController desktopController) {
        this.desktopController = desktopController;
    }

    @Override
    public DesktopStyle getGlobalStyle() {
        Dimension menuItemSize = new Dimension(100,30);

        return style()
            .set(JMenuItem.class, view -> {
                view.setPreferredSize(menuItemSize);
                view.setOpaque(true);
                view.setMnemonic(view.getText().isEmpty() ? 0 : view.getText().charAt(0));
            })
            .set(JMenu.class, view -> {
                view.setPreferredSize(menuItemSize);
                view.setBorder(BorderFactory.createMatteBorder(0,0,5,0,new Color(0,0,0,0)));
                view.addMenuListener(new MenuListener() {
                    @Override
                    public void menuSelected(MenuEvent menuEvent) {
                        view.setBorder(BorderFactory.createMatteBorder(0,0,5,0,Color.orange));
                    }

                    @Override
                    public void menuDeselected(MenuEvent menuEvent) {
                        view.setBorder(null);
                    }

                    @Override
                    public void menuCanceled(MenuEvent menuEvent) {
                        view.setBorder(null);
                    }
                });

                view.setBorderPainted(true);
                view.setMnemonic(view.getText().isEmpty() ? 0 : view.getText().charAt(0));
            });
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
        return menuBar(
            menu("File",
                menuItem("Load").accelerator(KeyStroke.getKeyStroke('C')),
                menuItem("Save"),
                menuItem("Close")
            ),
            menu("Edit",
                menuItem("Cut").actionListener(desktopController::cutPresed),
                menuItem("Copy"),
                menuItem("Paste")
            ),
            menu("RadioButtons",
                buttonGroupInMenu(
                    radioButtonMenuItem("Radio 1"),
                    radioButtonMenuItem("Radio 2")
                )
            ),
            menu("CheckBoxes",
                checkBoxMenuItem("CheckBox 1"),
                checkBoxMenuItem("CheckBox 2")
            ),
            menu("Help",
                menuItem("Manual"),
                menuItem("About")
            )
        );
    }

}
