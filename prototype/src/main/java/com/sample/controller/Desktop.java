package com.sample.controller;

import org.fluentness.controller.AbstractDesktop;
import org.fluentness.controller.Swing.Swing;

import javax.swing.*;

import static org.fluentness.controller.Swing.SwingAttribute.CLASS;
import static org.fluentness.controller.Swing.SwingAttribute.ID;

public class Desktop extends AbstractDesktop {

    public Desktop() {
        super(
            frame(ID + "Fluentness rocks",
                panel(ID + "panel1", CLASS + "panel",
                    panel(CLASS + "panel",
                        button(ID + "daButton", "Test button"),
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
            )
        );
    }

    private Swing<JMenuBar> topBar() {
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
