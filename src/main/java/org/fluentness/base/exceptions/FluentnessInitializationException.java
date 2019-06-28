package org.fluentness.base.exceptions;

public class FluentnessInitializationException extends Exception {

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

    public FluentnessInitializationException(String message) {
        this.message = message;
    }

    public FluentnessInitializationException(String message, Exception exception) {
        this.message = message;
        this.exception = exception;
    }

    public FluentnessInitializationException(Exception exception) {
        this.exception = exception;
    }

    public FluentnessInitializationException(String messageToFormat, Object... parameters) {
        this.message = String.format(messageToFormat, parameters);
    }
}
