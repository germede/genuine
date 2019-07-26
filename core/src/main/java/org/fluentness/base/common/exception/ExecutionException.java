package org.fluentness.base.common.exception;

public class ExecutionException extends AbstractException {


    public ExecutionException(String message) {
        super(message);
    }

    public ExecutionException(String message, Exception exception) {
        super(message, exception);
    }

    public ExecutionException(Exception exception) {
        super(exception);
    }

    public ExecutionException(String messageToFormat, Object... parameters) {
        super(messageToFormat, parameters);
    }
}
