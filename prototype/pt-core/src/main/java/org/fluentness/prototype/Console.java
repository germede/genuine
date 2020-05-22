package org.fluentness.prototype;

import org.fluentness.AbstractConsole;
import org.fluentness.Fluentness;
import org.fluentness.FluentnessException;
import org.fluentness.prototype.controller.ConsoleController;

public class Console extends AbstractConsole {

    public Console(ConsoleController consoleController) {
        super(consoleController);
    }

    public static void main(String[] args) throws FluentnessException {
        Fluentness.launch(Console.class, args);
    }
}
