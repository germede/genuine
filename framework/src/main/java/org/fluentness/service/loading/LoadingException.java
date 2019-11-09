package org.fluentness.service.loading;

import org.fluentness.FluentnessException;

public class LoadingException extends FluentnessException {
    LoadingException(Exception exception) {
        super(exception);
    }
}
