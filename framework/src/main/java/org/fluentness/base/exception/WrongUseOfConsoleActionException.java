package org.fluentness.base.exception;

public class WrongUseOfConsoleActionException extends AbstractException {

    public WrongUseOfConsoleActionException(String stringToFormat, Object... parameters) {
        super(stringToFormat, parameters);
    }
}
