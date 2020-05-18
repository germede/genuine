package com.sample.controller;

import org.fluentness.controller.AbstractDesktop;
import org.fluentness.controller.DesktopTemplate;

import javax.swing.*;

public class Desktop extends AbstractDesktop {

    JPanel panel1;
    JPanel panel2;
    JButton button;

    @Override
    public DesktopTemplate getTemplate() {
        return frame("My frame",
            panel1 = panel(
                panel2 = panel(
                    button = button("Test button"),
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
                    )
                )//.flowLayout()
            )//.borderLayout(BorderLayout.NORTH, BorderLayout.SOUTH)
        );
    }

    private JMenuBar menuBar() {
        return menuBar(
            menu("File",
                menuItem("Load"),//.accelerator(KeyStroke.getKeyStroke('C')),
                menuItem("Save"),
                menuItem("Close")
            ),
            menu("Edit",
                menuItem("Cut"),//.actionListener(controller::cutPressed),
                menuItem("Copy"),
                menuItem("Paste")
            ),
            menu("RadioButtons"
//                buttonGroup(
//                    radioButtonMenuItem("Radio 1"),
//                    radioButtonMenuItem("Radio 2")
//                )
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
