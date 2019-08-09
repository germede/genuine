package org.fluentness.base.service.configuration;

import org.fluentness.base.service.logger.LogLevel;

public final class FluentnessSettings {

    public static final Setting<String> appProtocol = new Setting<>();
    public static final Setting<String> appHost = new Setting<>();
    public static final Setting<Integer> appPort = new Setting<>();
    public static final Setting<String> PERSISTENCE_UNIT = new Setting<>();
    public static final Setting<LogLevel> logLevel = new Setting<>();
    public static final Setting<Boolean> logToConsole = new Setting<>();
    public static final Setting<String> LOG_TO_FILE = new Setting<>();
    public static final Setting<String> VIEW_CACHE_DIRECTORY = new Setting<>();
    public static final Setting<Boolean> compressStyles = new Setting<>();
}
