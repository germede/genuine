package org.fluentness;

import org.fluentness.common.logging.Logger;
import org.fluentness.common.namedValues.NamedValue;
import org.fluentness.controller.ControllerProvider;
import org.fluentness.task.DefaultTasks;
import org.fluentness.task.Task;
import org.fluentness.task.TaskProvider;

import java.util.Arrays;
import java.util.Map;

public final class FnBoot {

    public static void initialize(String[] args, NamedValue<Object>... settings) {

        FnConf.setSettings(settings);

        if (args.length <= 0) {
            args = new String[]{"help"};
        }

        // merge default and custom tasks
        Map<String, Task> tasks = new DefaultTasks().provideAll();
        TaskProvider taskProvider = FnAtoz.getTaskProvider();
        Map<String, Task> map = taskProvider.provideAll();
        tasks.putAll(map);
        ControllerProvider asdf = FnAtoz.getControllerProvider();

        String[] finalArgs = args;
        if (tasks.keySet().stream().noneMatch(task -> task.equals(finalArgs[0]))) {
            Logger.error(FnBoot.class, "No task %s found", args[0]);
            return;
        }

        Task taskToExecute = tasks.entrySet().stream().filter(task -> task.getKey().equals(finalArgs[0])).findFirst().get().getValue();
        String[] declaredParameters = taskToExecute.getParameters();
        if (declaredParameters.length != args.length - 1) {
            Logger.error(FnBoot.class, "Wrong use of command %s, expected %s arguments", args[0], declaredParameters.length);
            return;
        }

        String[] parameters = new String[declaredParameters.length];
        System.arraycopy(args, 1, parameters, 0, args.length - 1);
        Arrays.stream(taskToExecute.getSteps()).forEach(step -> step.value().getExecutor().execute(parameters));
    }
}
