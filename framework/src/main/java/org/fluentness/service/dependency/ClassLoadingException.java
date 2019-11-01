package org.fluentness.service.dependency;

import org.fluentness.Exception;

public class ClassLoadingException extends Exception {
    ClassLoadingException(java.lang.Exception exception) {
        super(exception);
    }
}
