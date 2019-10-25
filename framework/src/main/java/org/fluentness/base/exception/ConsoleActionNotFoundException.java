package org.fluentness.base.exception;

public class ConsoleActionNotFoundException extends AbstractException {

    public ConsoleActionNotFoundException(String stringToFormat, Object... parameters) {
        super(stringToFormat,parameters);
    }
}
