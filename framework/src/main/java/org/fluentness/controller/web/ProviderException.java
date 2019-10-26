package org.fluentness.controller.web;

import org.fluentness.AbstractException;

public class ProviderException extends AbstractException {

    public ProviderException(String stringToFormat, Object... parameters) {
        super(stringToFormat, parameters);
    }
}
