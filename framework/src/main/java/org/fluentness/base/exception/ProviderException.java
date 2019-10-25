package org.fluentness.base.exception;

public class ProviderException extends AbstractException {

    public ProviderException(String stringToFormat, Object... parameters) {
        super(stringToFormat, parameters);
    }
}
