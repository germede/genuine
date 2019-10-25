package org.fluentness.backbone.exception;

public class DefinitionException extends AbstractException {

    public DefinitionException(java.lang.Exception exception) {
        super(exception);
    }

    public DefinitionException(String messageToFormat, Object... parameters) {
        super(messageToFormat, parameters);
    }
}
