package org.fluentness.service.injection;

import org.fluentness.FluentnessException;

public class InjectionException extends FluentnessException {

    public InjectionException(Throwable cause) {
        super(cause);
    }

    public InjectionException(String messageToFormat, Object... parameters) {
        super(messageToFormat, parameters);
    }
}
