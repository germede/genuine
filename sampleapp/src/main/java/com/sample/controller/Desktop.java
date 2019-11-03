package com.sample.controller;

import org.fluentness.controller.desktop.swing.container.SwingFrame;

import javax.swing.*;

import java.awt.*;

import static org.fluentness.controller.desktop.DesktopViewFactory.*;

public class Desktop {

    static {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }
    }

    SwingFrame main() {
        return frame(
            panel(
                label("this is a test text")
//                button("title").border(BorderFactory.createEmptyBorder(20,20,20,20))
            ).layout(new BorderLayout())
        ).title("Fluentness rocks").bounds(0, 0, 800, 600).center().minimumSize(300,300).preferredSize(800,600);
    }

    public static void main(String[] args) {
        new Desktop().main();
    }
}
