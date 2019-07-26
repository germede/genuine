package org.fluentness.base.common.exception;

public class ProducerException extends AbstractException {

    public ProducerException(String stringToFormat, Object... parameters) {
        super(stringToFormat, parameters);
    }
}
