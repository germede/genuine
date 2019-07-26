package org.fluentness.base.common.exception;

public class WrongUseOfTaskException extends AbstractException {

    public WrongUseOfTaskException(String stringToFormat, Object... parameters) {
        super(stringToFormat,parameters);
    }

}
