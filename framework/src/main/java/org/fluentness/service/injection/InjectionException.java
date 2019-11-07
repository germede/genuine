package org.fluentness.service.injection;

import org.fluentness.FluentnessException;

public class InjectionException extends FluentnessException {
    InjectionException(java.lang.Exception exception) {
        super(exception);
    }

    InjectionException(String messageToFormat, Object... parameters) {
        super(messageToFormat, parameters);
    }
}
