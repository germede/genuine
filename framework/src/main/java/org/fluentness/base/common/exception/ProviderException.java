package org.fluentness.base.common.exception;

public class ProviderException extends AbstractException {

    public ProviderException(String stringToFormat, Object... parameters) {
        super(stringToFormat, parameters);
    }
}
