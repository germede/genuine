package org.fluentness;

import org.fluentness.base.Base;
import org.fluentness.base.exceptions.FluentnessInitializationException;
import org.fluentness.data.Data;
import org.fluentness.flow.Flow;
import org.fluentness.flow.task.Task;
import org.fluentness.flow.task.TaskProvider;

public class Fluentness {

    public static Base base = new Base();
    public static Data data = new Data();
    public static Flow flow = new Flow();

    public static String appPackage;

    public static void initialize(String appPackage, String[] args) {
        Fluentness.appPackage = appPackage;
        try {

            base.initialize();
            data.initialize();
            flow.initialize();

            executeCommand(args);
        } catch (FluentnessInitializationException e) {
            e.printStackTrace();
        }
    }

    private static void executeCommand(String[] args) throws FluentnessInitializationException {

        TaskProvider tasks = Fluentness.flow.getProvider(TaskProvider.class);

        if (args.length == 0) {
            tasks.getComponent("help").execute(args);
            System.exit(0);
        }

        String taskName = args[0];
        Task taskToExecute = null;
        String[] declaredArguments = new String[0];
        for (Task task : tasks.getComponents()) {
            if (taskName.equals(task.getName())) {
                taskToExecute = task;
                declaredArguments = task.getArguments();
                break;
            }
        }

        if (taskToExecute == null) {
            throw new FluentnessInitializationException("No %s task found", taskName);
        }

        if (declaredArguments.length != args.length - 1) {
            throw new FluentnessInitializationException("Wrong use of task %s, expected %s arguments, got %s",
                taskToExecute.getName(),
                declaredArguments.length,
                args.length - 1
            );
        }

        String[] arguments = new String[declaredArguments.length];
        System.arraycopy(args, 1, arguments, 0, args.length - 1);
        taskToExecute.execute(arguments);
    }
}
