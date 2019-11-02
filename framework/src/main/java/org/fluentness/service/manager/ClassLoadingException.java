package org.fluentness.service.manager;

import org.fluentness.FluentnessException;

public class ClassLoadingException extends FluentnessException {
    ClassLoadingException(java.lang.Exception exception) {
        super(exception);
    }
}
