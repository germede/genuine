package org.fluentness.base.service.configuration;

import org.fluentness.base.common.annotation.DefinitionPriority;
import org.fluentness.base.service.Service;
import org.fluentness.base.service.logger.FluentnessLogLevel;

@DefinitionPriority(0)
public interface Configuration extends Service {

    class Setting<T> {
    }

    Setting<Integer> APP_PORT = new Setting<>();
    Setting<String> APP_PROTOCOL = new Setting<>();
    Setting<String> APP_HOSTNAME = new Setting<>();
    Setting<String> PERSISTENCE_UNIT = new Setting<>();
    Setting<Boolean> ENABLE_CACHE = new Setting<>();
    Setting<Boolean> ENABLE_LOG_TO_CONSOLE = new Setting<>();
    Setting<Boolean> ENABLE_LOG_TO_FILE = new Setting<>();
    Setting<Boolean> ENABLE_STYLE_MINIFY = new Setting<>();

    Setting<FluentnessLogLevel> LOG_LEVEL = new Setting<>();

    <T> boolean has(Setting<T> key);

    <T> T get(Setting<T> key);

    <T> Configuration set(Setting<T> key, T value);

    void configure();
}
