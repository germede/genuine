package org.fluentness.base.logger;

import org.fluentness.base.Service;

public interface Logger extends Service<S> {

    void debug(String message, Object... parameters);

    void info(String message, Object... parameters);

    void warn(String message, Object... parameters);

    void error(String message, Object... parameters);

    void error(Exception exception);

}

