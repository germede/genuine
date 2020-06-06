package org.fluentness.service.instantiation;

public class InstantiationException extends java.lang.Exception {

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

    InstantiationException(Throwable cause) {
        this.cause = cause;
    }

    InstantiationException(String messageToFormat, Object... parameters) {
        this.message = String.format(messageToFormat, parameters);
    }
}
