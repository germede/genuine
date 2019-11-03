package com.sample.controller;

import org.fluentness.controller.desktop.swing.container.SwingFrame;

import javax.swing.*;

import java.awt.*;

import static org.fluentness.controller.desktop.DesktopViewFactory.*;

public class Desktop {

    private DesktopController desktopController;

    public Desktop(DesktopController desktopController) {
        this.desktopController = desktopController;
    }

    SwingFrame main() {
        return frame(
            panel(
//                label("this is a test text")
                button("test_button")
                    .text("Test button")
                    .border(BorderFactory.createEmptyBorder(20, 20, 20, 20))
                    .action(desktopController::showInfoMessage)
            ).layout(new BorderLayout())
        ).title("Fluentness rocks").bounds(0, 0, 800, 600).center().minimumSize(300, 300).preferredSize(800, 600);
    }

}
