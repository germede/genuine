package org.fluentness.service.dependency;

import org.fluentness.Exception;

class InjectionException extends Exception {
    InjectionException(java.lang.Exception exception) {
        super(exception);
    }

    InjectionException(String messageToFormat, Object... parameters) {
        super(messageToFormat, parameters);
    }
}
