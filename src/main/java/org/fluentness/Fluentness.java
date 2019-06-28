package org.fluentness;

import org.fluentness.base.exceptions.FluentnessInitializationException;
import org.fluentness.data.Data;
import org.fluentness.flow.Flow;
import org.fluentness.flow.task.Task;
import org.fluentness.flow.task.TaskProvider;

public enum Fluentness {

    call;

    public void initialize(String configurationToApply, String[] programArguments) {
        try {
            try {
                String appPackage = Class.forName(
                    Thread.currentThread().getStackTrace()[Thread.currentThread().getStackTrace().length - 1].getClassName()
                ).getPackage().getName();
                Flow.call.initialize(appPackage, configurationToApply);
                Data.call.initialize(appPackage);
            } catch (ClassNotFoundException e) {
                throw new FluentnessInitializationException(
                    "Fluentness initializer should be called in main method, calling class should be public", e
                );
            }
            executeCommand(programArguments);
        } catch (FluentnessInitializationException e) {
            e.printStackTrace();
        }
    }


    private void executeCommand(String[] args) throws FluentnessInitializationException {

        TaskProvider tasks = Flow.call.tasks;
        if (args.length == 0) {
            tasks.get("print:help").execute(args);
            System.exit(0);
        }

        String taskName = args[0];
        Task taskToExecute = null;
        String[] declaredArguments = new String[0];
        for (Task task : tasks.getAll()) {
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
