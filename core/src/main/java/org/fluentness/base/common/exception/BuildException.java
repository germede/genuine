package org.fluentness.base.common.exception;

public class BuildException extends AbstractException {

    public BuildException(String message) {
        super(message);
    }

    public BuildException(String message, Exception exception) {
        super(message, exception);
    }

    public BuildException(Exception exception) {
        super(exception);
    }

    public BuildException(String messageToFormat, Object... parameters) {
        super(messageToFormat, parameters);
    }
}
