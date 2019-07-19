package org.fluentness;

import org.fluentness.base.exceptions.FluentnessInitializationException;
import org.fluentness.base.logging.Log;
import org.fluentness.base.networking.HttpServer;
import org.fluentness.base.settings.Key;
import org.fluentness.base.settings.Settings;
import org.fluentness.data.Data;
import org.fluentness.flow.Flow;
import org.fluentness.flow.task.Task;
import org.fluentness.flow.task.TaskProvider;

import javax.lang.model.type.PrimitiveType;
import java.io.Serializable;

public enum Fluentness {
    instance;

    static {
        Settings.instance.initialize();
    }

    public <T> Fluentness set(Key<T> key, T value) {
        Settings.instance.set(key, value);
        return this;
    }

    public void initialize(String[] args) {
        try {
            try {
                String appPackage = Class.forName(
                    Thread
                        .currentThread()
                        .getStackTrace()[Thread.currentThread().getStackTrace().length - 1]
                        .getClassName()
                ).getPackage().getName();

                Log.instance.initialize();
                Data.instance.initialize(appPackage);
                Flow.instance.initialize(appPackage);
                HttpServer.instance.initialize();
                executeCommand(args);

            } catch (ClassNotFoundException e) {
                throw new FluentnessInitializationException(
                    "Fluentness initializer should be called in main method, calling class should be public", e
                );
            }
        } catch (FluentnessInitializationException e) {
            e.printStackTrace();
        }
    }


    private void executeCommand(String[] args) throws FluentnessInitializationException {

        TaskProvider tasks = Flow.instance.tasks;

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
