package com.sample.controller;

import org.fluentness.controller.desktop.DesktopView;
import org.fluentness.controller.desktop.template.DesktopTemplate;
import org.fluentness.controller.desktop.template.swing.Swing;

import javax.swing.*;

import static org.fluentness.controller.desktop.template.swing.SwingAttribute.CLASS;
import static org.fluentness.controller.desktop.template.swing.SwingAttribute.ID;
import static org.fluentness.controller.desktop.template.swing.SwingFactory.*;

public class Desktop implements DesktopView {

    @Override
    public DesktopTemplate getTemplate() {
        return frame(ID + "Fluentness rocks",
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
        );//.bounds(0, 0, 800, 600).center().minimumSize(300, 300).menuBar(topBar());
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
