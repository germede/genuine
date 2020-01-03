package com.sample.controller;

import org.fluentness.controller.desktop.View;
import org.fluentness.controller.desktop.style.DesktopStyle;
import org.fluentness.controller.desktop.template.DesktopTemplate;
import org.fluentness.controller.desktop.template.swing.Swing;

import javax.swing.*;

import static org.fluentness.controller.desktop.style.DesktopStyleFactory.byClass;
import static org.fluentness.controller.desktop.style.DesktopStyleFactory.ubuntuStyle;
import static org.fluentness.controller.desktop.template.swing.SwingFactory.*;

public class Desktop implements View {

    @Override
    public DesktopStyle getStyle() {
        return ubuntuStyle(

//            byId("")


            byClass(JTable.class, jTable -> jTable.setDragEnabled(false)),
            byClass(JFrame.class, jFrame -> jFrame.setJMenuBar(topBar().getActualSwing()))
        );
    }

    @Override
    public DesktopTemplate getTemplate() {
        return frame("Fluentness rocks",
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
