package org.fluentness.service.serving;

import org.fluentness.FluentnessException;

public class ServingException extends FluentnessException {
    protected ServingException(Exception exception) {
        super(exception);
    }
}
