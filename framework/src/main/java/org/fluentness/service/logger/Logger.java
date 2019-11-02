package org.fluentness.service.logger;

import org.fluentness.service.Service;

public interface Logger extends Service {

    void debug(String message, Object... parameters);

    void info(String message, Object... parameters);

    void warning(String message, Object... parameters);

    void error(String message, Object... parameters);

    void error(Throwable throwable);

}

