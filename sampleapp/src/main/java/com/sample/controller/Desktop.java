package com.sample.controller;

import org.fluentness.controller.desktop.swing.component.MenuBarView;
import org.fluentness.controller.desktop.swing.container.JFrameView;
import org.fluentness.controller.desktop.swing.component.PanelView;

import javax.swing.*;

import java.awt.*;

import static org.fluentness.controller.desktop.DesktopViewFactory.*;

public class Desktop {

    private DesktopController desktopController;

    public Desktop(DesktopController desktopController) {
        this.desktopController = desktopController;
    }

    JFrameView main() {
        return frame(
            panel(
                topBar(),
                mainPanel()
            ).borderLayout(BorderLayout.NORTH, BorderLayout.SOUTH)
        ).title("Fluentness rocks").bounds(0, 0, 800, 600).center().minimumSize(300, 300);
    }

    private PanelView mainPanel() {
        return panel(
            label("Test label")
                .toolTipText("Creates a new book"),
            button("Test button").maximumSize(20, 20)
            //.actionLi(desktopController::showInfoMessage)
        ).layout(new FlowLayout());
    }

    private MenuBarView topBar() {
        return menuBar(
            menu("File",
                menuItem("Load").accelerator(KeyStroke.getKeyStroke('C')),
                menuItem("Save"),
                menuItem("Close")
            ).mnemonic('F'),
            menu("Edit",
                menuItem("Cut"),
                menuItem("Copy"),
                menuItem("Paste")
            ).mnemonic('E'),
            menu("RadioButtons",
                radioButtonMenuItem("Radio 1"),
                radioButtonMenuItem("Radio 2")
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
