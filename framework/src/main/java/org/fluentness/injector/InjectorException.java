package org.fluentness.injector;

import org.fluentness.FluentnessException;

public class InjectorException extends FluentnessException {
    InjectorException(java.lang.Exception exception) {
        super(exception);
    }

    InjectorException(String messageToFormat, Object... parameters) {
        super(messageToFormat, parameters);
    }
}
