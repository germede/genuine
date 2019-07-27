package org.fluentness.base.common.exception;

public class DefinitionException extends AbstractException {

    public DefinitionException(String message) {
        super(message);
    }

    public DefinitionException(String message, Exception exception) {
        super(message, exception);
    }

    public DefinitionException(Exception exception) {
        super(exception);
    }

    public DefinitionException(String messageToFormat, Object... parameters) {
        super(messageToFormat, parameters);
    }
}
