package com.sample.controller;

import org.fluentness.controller.desktop.swing.component.JMenuBarBuilder;
import org.fluentness.controller.desktop.swing.container.JFrameBuilder;
import org.fluentness.controller.desktop.swing.component.JPanelBuilder;

import javax.swing.*;

import java.awt.*;

import static org.fluentness.controller.desktop.DesktopViewFactory.*;

public class Desktop {

    private DesktopController desktopController;

    public Desktop(DesktopController desktopController) {
        this.desktopController = desktopController;
    }

    JFrameBuilder main() {
        return frame(
            panel(
                topBar().position(),
                mainPanel().position()
            ).borderLayout(BorderLayout.SOUTH, BorderLayout.EAST, BorderLayout.WEST, BorderLayout.SOUTH)
        ).title("Fluentness rocks").bounds(0, 0, 800, 600).center().minimumSize(300, 300);
    }

    private JPanelBuilder mainPanel() {
        return panel(
            label("test_label")
                .text("Test 1234")
                .toolTipText("Creates a new book"),
            button()
                .text("Test button")
                .maximumSize(20, 20)
            //.actionLi(desktopController::showInfoMessage)
        ).layout(new FlowLayout());
    }

    private JMenuBarBuilder topBar() {
        return menuBar(
            menu("File",
                menuItem("Load").accelerator(KeyStroke.getKeyStroke('C')),
                menuItem("Save"),
                menuItem("Close")
            ),
            menu("Edit",
                menuItem("Cut"),
                menuItem("Copy"),
                menuItem("Paste")
            ),
            menu("Help",
                menuItem("Manual"),
                menuItem("About")
            )
        );
    }

}
