package org.fluentness.service.log;

import org.fluentness.service.Service;
import org.fluentness.service.configuration.Setting;

public interface Log extends Service {

    Setting<LogLevel> LEVEL = new Setting<>(INFO);
    Setting<Boolean> CONSOLE = new Setting<>(true);
    Setting<String> FILE = new Setting<>();

    default void trace(String message, Object... parameters) {
        log(TRACE, message, parameters);
    }

    default void debug(String message, Object... parameters) {
        log(DEBUG, message, parameters);
    }

    default void info(String message, Object... parameters) {
        log(INFO, message, parameters);
    }

    default void warn(String message, Object... parameters) {
        log(WARN, message, parameters);
    }

    default void error(String message, Object... parameters) {
        log(LogLevel.ERROR, message, parameters);
    }

    default void error(Throwable throwable) {
        StringBuilder errorMsg = new StringBuilder();
        while (true) {
            if (throwable.getMessage() == null) {
                errorMsg.append(throwable.getClass().getSimpleName())
                        .append(":");
            } else {
                errorMsg.append(throwable.getClass().getSimpleName())
                        .append(" ")
                        .append(throwable.getMessage())
                        .append(":");
            }
            for (StackTraceElement stackTraceElement : throwable.getStackTrace()) {
                errorMsg.append("\n    ")
                        .append(stackTraceElement.toString());
            }

            if (throwable.getCause() != null) {
                errorMsg.append("\nCaused by ");
                throwable = throwable.getCause();
            } else {
                break;
            }
        }
        error(errorMsg.toString());
    }

    void log(LogLevel level, String message, Object[] parameters);
}

