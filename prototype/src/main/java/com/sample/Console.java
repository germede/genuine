package com.sample;

import org.fluentness.AbstractConsole;
import org.fluentness.Fluentness;
import org.fluentness.FluentnessException;
import org.fluentness.controller.ConsoleController;

public class Console extends AbstractConsole {

    public Console(ConsoleController consoleController) {
        super(consoleController);
    }

    public static void main(String[] args) throws FluentnessException {
        Fluentness.launch(Console.class, args);
    }
}
