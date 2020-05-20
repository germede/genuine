package com.sample;

import org.fluentness.AbstractConsoleApplication;
import org.fluentness.Fluentness;
import org.fluentness.FluentnessException;
import org.fluentness.controller.ConsoleController;

public class ConsoleApplication extends AbstractConsoleApplication {

    public ConsoleApplication(ConsoleController consoleController) {
        super(consoleController);
    }

    public static void main(String[] args) throws FluentnessException {
        Fluentness.launch(ConsoleApplication.class, args);
    }
}
