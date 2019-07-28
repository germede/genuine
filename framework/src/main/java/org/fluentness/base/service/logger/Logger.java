package org.fluentness.base.service.logger;

import org.fluentness.base.common.annotation.DefinitionPriority;
import org.fluentness.base.service.Service;

@DefinitionPriority(200)
public interface Logger<OwnLogLevel> extends Service {

    void debug(String message, Object... parameters);

    void info(String message, Object... parameters);

    void warn(String message, Object... parameters);

    void error(String message, Object... parameters);

    void error(Exception exception);

    FluentnessLogLevel ownLogLevelToFluentnessLogLevel(OwnLogLevel level);

    OwnLogLevel FluentnessLogLevelToOwnLogLevel(FluentnessLogLevel level);

}

