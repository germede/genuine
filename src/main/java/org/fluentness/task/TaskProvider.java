package org.fluentness.task;

import org.fluentness.Fluentness;
import org.fluentness.base.constants.AnsiColors;
import org.fluentness.base.generics.Provider;
import org.fluentness.base.lambdas.KeyValuePair;

import java.util.HashMap;
import java.util.Map;

public interface TaskProvider extends Provider<Task>, AnsiColors {

    default String[] parameters(String... parameters) {
        return parameters;
    }

    default Task commands(KeyValuePair<Command>... commands) {
        return new Task(commands);
    }

    default Command command(String[] parameters, String description, CommandExecutor executor) {
        return new Command(parameters, description, executor);
    }

    default Command command(String description, CommandExecutor executor) {
        return new Command(new String[0], description, executor);
    }

    static Map<String,Command> retrieveAllCommands() {
        Map<String, Task> tasks = new TaskProviderImpl().getAll();
        tasks.putAll(Fluentness.get.tasks.getAll());

        Map<String,Command> result = new HashMap<>();
        for (Map.Entry<String, Task> task : tasks.entrySet()) {
            for (KeyValuePair<Command> command : task.getValue().getCommands()) {
                if (task.getValue().getCommands().length == 1){
                    result.put(command.key(),command.value());
                } else {
                    result.put(task.getKey() + ":" + command.key(), command.value());
                }
            }
        }
        return result;
    }

}
