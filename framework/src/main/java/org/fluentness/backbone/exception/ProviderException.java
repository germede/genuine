package org.fluentness.backbone.exception;

public class ProviderException extends AbstractException {

    public ProviderException(String stringToFormat, Object... parameters) {
        super(stringToFormat, parameters);
    }
}
