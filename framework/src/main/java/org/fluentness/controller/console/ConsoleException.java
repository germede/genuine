package org.fluentness.controller.console;

import org.fluentness.FluentnessException;

public class ConsoleException extends FluentnessException {
    public ConsoleException(String stringToFormat, Object... parameters) {
        super(stringToFormat, parameters);
    }
}
