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

    public AbstractException(String message) {
        this.message = message;
    }

    public AbstractException(String message, Exception exception) {
        this.message = message;
        this.exception = exception;
    }

    public AbstractException(Exception exception) {
        this.exception = exception;
    }

    public AbstractException(String messageToFormat, Object... parameters) {
        this.message = String.format(messageToFormat, parameters);
    }
}
