package org.fluentness.controller;

import org.fluentness.Exception;

public class ConsoleException extends Exception {
    public ConsoleException(String stringToFormat, Object... parameters) {
        super(stringToFormat, parameters);
    }
}
