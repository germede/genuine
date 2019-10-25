package org.fluentness.base.service.logger;

import org.fluentness.base.service.Service;

public interface Logger extends Service {

    void debug(String message, Object... parameters);

    void info(String message, Object... parameters);

    void warn(String message, Object... parameters);

    void error(String message, Object... parameters);

    void error(Exception exception);

}

