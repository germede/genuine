package org.fluentness.command;

import org.fluentness.common.AnsiColors;
import org.fluentness.common.ClassicNamedValue;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public interface Command extends AnsiColors {

    String getName();

    String getDescription();

    default Parameters getParameters() {
        return new Parameters();
    }

    default String getUsage() {
        String format = ANSI_CYAN + "    %-40s " + ANSI_RESET + "%s";
        return String.format(format, getName() + ANSI_BLACK + getParameters().toString(), getDescription());
    }

    void execute(Parameters parameters);

    class Parameters {

        private List<ClassicNamedValue> parameters;

        public Parameters() {
            parameters = new ArrayList<>();
        }

        public Command.Parameters add(String name) {
            parameters.add(new ClassicNamedValue(name, ""));
            return this;
        }

        public String get(String name) {
            return parameters.stream().filter(parameter -> parameter.name.equals(name)).findFirst().get().value;
        }

        public void set(int i, String arg) {
            parameters.get(i).value = arg;
        }

        public List<ClassicNamedValue> getList() {
            return parameters;
        }

        public boolean contains(String key) {
            return parameters.stream().anyMatch(parameter -> parameter.name.equals(key) && !parameter.value.isEmpty());
        }

        public int size() {
            return parameters.size();
        }

        @Override
        public String toString() {
            if (parameters.isEmpty()) {
                return "";
            }
            return " [" + parameters.stream().map(nameValuePair -> nameValuePair.name)
                    .collect(Collectors.joining("][")) + "]";
        }
    }
}