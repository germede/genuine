package org.fluentness;

// basic exception class (checked)
public class FluentnessException extends java.lang.Exception {

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

    protected FluentnessException(Throwable cause) {
        this.cause = cause;
    }

    protected FluentnessException(String messageToFormat, Object... parameters) {
        this.message = String.format(messageToFormat, parameters);
    }
}
