package com.sample.controller;

import org.fluentness.controller.desktop.AbstractDesktopController;
import org.fluentness.persistence.Persistence;
import org.fluentness.view.desktop.SwingViewRegistry;
import org.fluentness.view.desktop.component.MenuBarView;
import org.fluentness.view.desktop.style.DesktopStyle;

import javax.swing.*;
import javax.swing.event.CaretEvent;
import java.awt.*;
import java.awt.event.ActionEvent;

import static org.fluentness.view.desktop.SwingViewFactory.*;
import static org.fluentness.view.desktop.SwingViewFactory.menuItem;
import static org.fluentness.view.desktop.style.DesktopStyleFactory.byClass;
import static org.fluentness.view.desktop.style.DesktopStyleFactory.ubuntuStyle;

public class Desktop extends AbstractDesktopController<java.awt.Desktop> {

    private Persistence persistence;

    public Desktop(Persistence persistence) {
        super(java.awt.Desktop.class);
        this.persistence = persistence;
    }

    @Override
    public DesktopStyle getStyle() {
        return ubuntuStyle(

//            byId("")


            byClass(JTable.class, jTable -> jTable.setDragEnabled(false))
        );
    }


    @Override
    public org.fluentness.controller.desktop.DesktopView getView() {
        return frame("Fluentness rocks",
            panel(
                panel(
                    action(CLICK, controller::dosomething,
                        colorChooser()
                    ),
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
                menuItem("Cut").actionListener(controller::cutPressed),
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

    public void test(CaretEvent caretEvent) {

        JCheckBox checkbox_2 = (JCheckBox) SwingViewRegistry.getByName(JCheckBox.class, "checkbox_2");
        checkbox_2.setText(checkbox_2.getText() + "HAHA");
    }

    public void cutPressed(ActionEvent event) {
        int i = 2;
    }

}
