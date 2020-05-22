package org.fluentness.service.log;

import org.fluentness.service.configuration.Setting;

public interface Log {

    Setting<LogLevel> LEVEL = new Setting<>(LogLevel.DEBUG);
    Setting<Boolean> CONSOLE = new Setting<>(true);
    Setting<String> FILE = new Setting<>();

    static String getLoggerCaller() {
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        for (StackTraceElement stackTraceElement : stackTrace) {
            if (!stackTraceElement.getClassName().startsWith("java.lang.Thread") &&
                    !stackTraceElement.getClassName().startsWith("java.util.logging") &&
                    !stackTraceElement.getClassName().startsWith("org.fluentness.service.log")) {
                return stackTraceElement.getClassName().replaceAll(".*\\.", "");
            }
        }
        return "Log";
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

