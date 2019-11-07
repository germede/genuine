package org.fluentness.service.loader;

import org.fluentness.FluentnessException;

public class LoaderException extends FluentnessException {
    LoaderException(Exception exception) {
        super(exception);
    }
}
