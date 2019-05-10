package org.fluentness.command;

import org.fluentness.common.AnsiColors;

import java.util.Arrays;

public interface Command extends AnsiColors {

    String getName();

    String getDescription();

    default String[] getParameters() {
        return new String[0];
    }

    default void printUsage() {
        String format = ANSI_CYAN + "    %-40s " + ANSI_RESET + "%s";
        System.out.println(String.format(format, getName() + ANSI_BLACK + Arrays.toString(getParameters()), getDescription()));
    }

    void execute(String... parameters);

}