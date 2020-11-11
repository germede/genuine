package org.fluentness.service.injector;

public class InjectorException extends java.lang.Exception {

    private String message;
    private Throwable cause;

    @Override
    public String getMessage() {
        return message != null ? message : super.getMessage();
    }

    @Override
    public StackTraceElement[] getStackTrace() {
        return message != null ? cause.getStackTrace() : super.getStackTrace();
    }

    @Override
    public synchronized Throwable getCause() {
        return cause != null ? cause : super.getCause();
    }

    InjectorException(Throwable cause) {
        this.cause = cause;
    }

    InjectorException(String messageToFormat, Object... parameters) {
        this.message = String.format(messageToFormat, parameters);
    }
}
