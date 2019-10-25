package org.fluentness.base.exception;

public class DefinitionException extends AbstractException {

    public DefinitionException(Exception exception) {
        super(exception);
    }

    public DefinitionException(String messageToFormat, Object... parameters) {
        super(messageToFormat, parameters);
    }
}
