package org.fluentness.prototype;

import org.fluentness.application.AbstractConsoleApplication;
import org.fluentness.Fluentness;
import org.fluentness.application.Application;
import org.fluentness.service.instantiation.InstantiationException;
import org.fluentness.prototype.service.Localization;

@Application.Services(Localization.class)
public class ConsoleApplication extends AbstractConsoleApplication {

    public ConsoleApplication(ConsoleController consoleController) {
        super(consoleController);
    }

    public static void main(String[] args) throws InstantiationException {
        Fluentness.launch(ConsoleApplication.class, args);
    }
}
