package com.sample.controller;

import com.bulenkov.darcula.DarculaLaf;
import org.fluentness.controller.desktop.AbstractDesktopController;
import org.fluentness.controller.desktop.DesktopView;
import org.fluentness.controller.desktop.swing.component.MenuBarView;

import javax.swing.*;
import javax.swing.event.CaretEvent;
import java.awt.*;
import java.awt.event.ActionEvent;

import static org.fluentness.controller.desktop.DesktopViewFactory.*;

public class DesktopController extends AbstractDesktopController {

    @Override
    public void setLookAndFeel() {
        // set custom look and feel instead of default system one
        try {
            UIManager.put("swing.boldMetal", Boolean.FALSE);
            UIManager.setLookAndFeel(new DarculaLaf());
        } catch (UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }
    }

    @Override
    public DesktopView getMainView() {
        return frame(
            panel(
                panel(
                    checkBox("Yes"), checkBox("Yes1"), checkBox("Yes2").name("checkbox_2"),
                    buttonGroup(
                        radioButton("No"),
                        radioButton("Maybe")
                    ),
                    colorChooser().color(200,200,200),
                    textArea().rows(5).columns(10).caretListener(this::test),
                    label("Test label")
                        .toolTipText("Creates a new book"),
                    button("Test button").maximumSize(20, 20)
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
            ).mnemonic('F'),
            menu("Edit",
                menuItem("Cut").actionListener(this::cutPresed),
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


    public void test(CaretEvent caretEvent) {
        JCheckBox checkbox_2 = getViewByName(JCheckBox.class, "checkbox_2");
        checkbox_2.setText(checkbox_2.getText()+"HAHA");
    }

    public void cutPresed(ActionEvent event) {
        int i = 2;
    }
}
