package org.fluentness;

import org.fluentness.base.Base;
import org.fluentness.base.BaseBuilder;
import org.fluentness.base.common.exception.BuildException;
import org.fluentness.base.common.exception.TaskNotFoundException;
import org.fluentness.base.common.exception.WrongUseOfTaskException;
import org.fluentness.data.Data;
import org.fluentness.data.DataBuilder;
import org.fluentness.flow.Flow;
import org.fluentness.flow.FlowBuilder;
import org.fluentness.flow.component.task.DefaultTaskProvider;
import org.fluentness.flow.component.task.Task;
import org.fluentness.flow.provider.Provider;

import java.util.concurrent.ExecutionException;

public abstract class Fluentness {

    private Base base;
    private Data data;
    private Flow flow;

    public Fluentness(String[] args) {
        try {
            base = buildBase(new BaseBuilder());
            data = buildData(new DataBuilder());
            flow = buildFlow(new FlowBuilder());

            execute(args);
        } catch (BuildException | ExecutionException e) {
            e.printStackTrace();
        }
    }

    protected abstract Base buildBase(BaseBuilder builder) throws BuildException;

    protected abstract Data buildData(DataBuilder builder) throws BuildException;

    protected abstract Flow buildFlow(FlowBuilder builder) throws BuildException;

    private void execute(String[] args) throws ExecutionException {
        try {
            Provider<Task> taskProvider = new DefaultTaskProvider();

            if (args.length == 0) {
                taskProvider.getComponent("help").execute(args);
                System.exit(0);
            }

            String taskName = args[0];
            Task taskToExecute = null;
            String[] declaredArguments = new String[0];
            for (Task task : taskProvider.getComponents()) {
                if (taskName.equals(task.getName())) {
                    taskToExecute = task;
                    declaredArguments = task.getArguments();
                    break;
                }
            }

            if (taskToExecute == null) {
                throw new TaskNotFoundException("No %s task found", taskName);
            }

            if (declaredArguments.length != args.length - 1) {
                throw new WrongUseOfTaskException("Wrong use of task %s, expected %s arguments, got %s",
                    taskToExecute.getName(),
                    declaredArguments.length,
                    args.length - 1
                );
            }

            String[] arguments = new String[declaredArguments.length];
            System.arraycopy(args, 1, arguments, 0, args.length - 1);
            taskToExecute.execute(arguments);

        } catch (TaskNotFoundException | WrongUseOfTaskException e) {
            throw new ExecutionException(e);
        }
    }
}