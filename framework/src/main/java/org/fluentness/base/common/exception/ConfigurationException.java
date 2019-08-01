package org.fluentness.base.common.exception;

public class ConfigurationException extends AbstractException {

    public ConfigurationException(String stringToFormat, Object... parameters) {
        super(stringToFormat, parameters);
    }
}
