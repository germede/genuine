package org.fluentness;

import org.fluentness.controller.AbstractDesktopController;

import javax.swing.*;

public abstract class AbstractDesktopApplication implements Application {

    private final AbstractDesktopController[] controllers;

    public AbstractDesktopApplication(AbstractDesktopController... controllers) {
        this.controllers = controllers;
    }

    @Override
    public void run(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }
        // get controller and run it
    }
}
