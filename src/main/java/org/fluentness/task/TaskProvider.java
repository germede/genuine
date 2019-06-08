package org.fluentness.task;

import org.fluentness.FnAtoz;
import org.fluentness.common.Provider;
import org.fluentness.common.constants.AnsiColors;
import org.fluentness.common.lambdas.NamedValue;
import org.fluentness.common.lambdas.NamedValueImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public interface TaskProvider extends Provider<Task>, AnsiColors {

    default String[] parameters(String... parameters) {
        return parameters;
    }

    default Task commands(NamedValue<Command>... commands) {
        return new Task(commands);
    }

    default Command command(String[] parameters, String description, CommandExecutor executor) {
        return new Command(parameters, description, executor);
    }

    default Command command(String description, CommandExecutor executor) {
        return new Command(new String[0], description, executor);
    }

    static List<NamedValue<Command>> retrieveAllCommands() {
        Map<String, Task> tasks = new DefaultTasks().provideAll();
        tasks.putAll(FnAtoz.getTaskProvider().provideAll());

        List<NamedValue<Command>> result = new ArrayList<>();
        for (Map.Entry<String, Task> task : tasks.entrySet()) {
            for (NamedValue<Command> command : task.getValue().getCommands()) {
                if (task.getValue().getCommands().length == 1){
                    result.add(command);
                } else {
                    result.add(new NamedValueImpl(task.getKey() + ":" + command.name(), command.value()));
                }
            }
        }
        return result;
    }

}
