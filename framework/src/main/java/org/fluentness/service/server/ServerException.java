package org.fluentness.service.server;

import org.fluentness.FluentnessException;

public class ServerException extends FluentnessException {
    protected ServerException(Exception exception) {
        super(exception);
    }
}
