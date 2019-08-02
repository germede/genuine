package org.fluentness.base.common.exception;

public abstract class AbstractException extends Exception {

    private String message;
    private Exception exception;

    @Override
    public String getMessage() {
        if (message != null) {
            return message;
        } else {
            return super.getMessage();
        }
    }

    @Override
    public StackTraceElement[] getStackTrace() {
        if (message != null) {
            return exception.getStackTrace();
        } else {
            return super.getStackTrace();
        }
    }

    @Override
    public synchronized Throwable getCause() {
        if (exception != null) {
            return exception;
        } else {
            return super.getCause();
        }
    }

    AbstractException(Exception exception) {
        this.exception = exception;
    }

    AbstractException(String messageToFormat, Object... parameters) {
        this.message = String.format(messageToFormat, parameters);
    }
}
