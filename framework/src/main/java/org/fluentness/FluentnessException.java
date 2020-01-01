package org.fluentness;

public class FluentnessException extends RuntimeException {

    private String message;
    private Exception exception;

    @Override
    public String getMessage() {
        return message != null ? message : super.getMessage();
    }

    @Override
    public StackTraceElement[] getStackTrace() {
        return message != null ? exception.getStackTrace() : super.getStackTrace();
    }

    @Override
    public synchronized Throwable getCause() {
        return exception != null ? exception : super.getCause();
    }

    protected FluentnessException(Exception exception) {
        this.exception = exception;
    }

    protected FluentnessException(String messageToFormat, Object... parameters) {
        this.message = String.format(messageToFormat, parameters);
    }
}
