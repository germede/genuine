package org.fluentness.service.logger;

import org.fluentness.service.Service;
import org.fluentness.service.Singleton;
import org.fluentness.service.configurator.Key;

@Singleton
public interface Logger extends Service {

    Key<LogLevel> LEVEL = new Key<>();
    Key<Boolean> CONSOLE = new Key<>();
    Key<String> FILE = new Key<>();

    static String getLoggerCaller() {
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        for (StackTraceElement stackTraceElement : stackTrace) {
            if (!stackTraceElement.getClassName().startsWith("java.lang.Thread") &&
                    !stackTraceElement.getClassName().startsWith("java.util.logging") &&
                    !stackTraceElement.getClassName().startsWith("org.fluentness.service.logger")) {
                return stackTraceElement.getClassName().replaceAll(".*\\.", "");
            }
        }
        return "Logger";
    }

    void log(LogLevel logLevel, String message, Object... parameters);

    void debug(String message, Object... parameters);

    void info(String message, Object... parameters);

    void warning(String message, Object... parameters);

    void error(String message, Object... parameters);

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
}

