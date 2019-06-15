package org.fluentness.task;

import org.fluentness.Fluentness;
import org.fluentness.base.generics.Component;
import org.fluentness.base.lambdas.KeyValuePair;

import java.util.HashMap;
import java.util.Map;

public class Task implements Component {

    private KeyValuePair<Command>[] commands;

    public Task(KeyValuePair<Command>[] commands) {
        this.commands = commands;
    }

    public KeyValuePair<Command>[] getCommands() {
        return commands;
    }

    public static Map<String,Command> retrieveAllCommands() {
        Map<String, Task> tasks = new FTaskProvider().getAll();
        tasks.putAll(Fluentness.INSTANCE.tasks.getAll());

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