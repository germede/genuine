package org.fluentness.base.service.logger;

import org.fluentness.base.service.Service;

public interface Logger<OwnLogLevel> extends Service {

    @Override
    default int getDefinitionPriority() {
        return 200;
    }

    void debug(String message, Object... parameters);

    void info(String message, Object... parameters);

    void warn(String message, Object... parameters);

    void error(String message, Object... parameters);

    void error(Exception exception);

    FluentnessLogLevel ownLogLevelToFluentnessLogLevel(OwnLogLevel level);

    OwnLogLevel fluentnessLogLevelToOwnLogLevel(FluentnessLogLevel level);

}

