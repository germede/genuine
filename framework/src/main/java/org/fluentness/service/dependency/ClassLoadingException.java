package org.fluentness.service.dependency;

import org.fluentness.FluentnessException;

public class ClassLoadingException extends FluentnessException {
    ClassLoadingException(java.lang.Exception exception) {
        super(exception);
    }
}
