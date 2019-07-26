package org.fluentness.base.common.exception;

public class InjectionException extends AbstractException {

    public InjectionException(String message) {
        super(message);
    }

    public InjectionException(String message, Exception exception) {
        super(message, exception);
    }

    public InjectionException(Exception exception) {
        super(exception);
    }

    public InjectionException(String messageToFormat, Object... parameters) {
        super(messageToFormat, parameters);
    }
}
