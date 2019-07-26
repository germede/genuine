package org.fluentness.base.common.exception;

public class TaskNotFoundException extends AbstractException {

    public TaskNotFoundException(String stringToFormat, Object... parameters) {
        super(stringToFormat,parameters);
    }

}
