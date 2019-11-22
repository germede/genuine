package org.fluentness.service.server;

import org.fluentness.FluentnessException;

public class ServingException extends FluentnessException {
    protected ServingException(Exception exception) {
        super(exception);
    }
}
