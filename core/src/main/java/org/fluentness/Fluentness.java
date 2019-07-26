package org.fluentness;

import org.fluentness.base.Base;
import org.fluentness.base.BaseDefinition;
import org.fluentness.base.common.environment.Environment;
import org.fluentness.base.common.exception.DefinitionException;
import org.fluentness.base.common.exception.TaskNotFoundException;
import org.fluentness.base.common.exception.WrongUseOfTaskException;
import org.fluentness.data.Data;
import org.fluentness.data.DataDefinition;
import org.fluentness.flow.Flow;
import org.fluentness.flow.FlowDefinition;
import org.fluentness.flow.producer.task.Task;
import org.fluentness.flow.producer.task.TaskProducer;

import java.util.LinkedList;
import java.util.List;

import static org.fluentness.base.common.constant.AnsiColors.*;

public abstract class Fluentness {

    private static Fluentness app;
    private static Environment environment;
    private static Base base;
    private static Data data;
    private static Flow flow;

    public static Environment getEnvironment() {
        return environment;
    }

    public static Base getBase() {
        return base;
    }

    public static Data getData() {
        return data;
    }

    public static Flow getFlow() {
        return flow;
    }

    private static List<Class> onionLayers = new LinkedList<>();

    public static void addOnionLayer(Class onionLayer) {
        onionLayers.add(onionLayer);
    }

    public static void printOnionLayers() {
        for (int i = 0; i < onionLayers.size(); i++) {
            String onionLayer = onionLayers.get(i).getSimpleName();
            if (i == 0) {
                System.out.println("\n" + ANSI_GREEN + "               ↑ ");
                System.out.println("LESS DEPENDANT | " + onionLayer + ANSI_RESET);
                continue;
            }
            if (i == onionLayers.size() - 1) {
                System.out.println(ANSI_BLUE + "MORE DEPENDANT | " + onionLayer);
                System.out.println("               ↓ " + ANSI_RESET);
                continue;
            }
            System.out.println("               | " + onionLayer);
        }
        System.out.println();
    }

    protected static Fluentness bootstrap(Fluentness app) {
        Fluentness.app = app;
        return app;
    }

    public Fluentness within(Environment environment) {
        environment.initialize();
        Fluentness.environment = environment;
        try {
            BaseDefinition baseDefinition = new BaseDefinition();
            DataDefinition dataDefinition = new DataDefinition();
            FlowDefinition flowDefinition = new FlowDefinition();

            app.defineBase(baseDefinition);
            app.defineData(dataDefinition);
            app.defineFlow(flowDefinition);

            base = baseDefinition.build();
            data = dataDefinition.build();
            flow = flowDefinition.build();

        } catch (DefinitionException e) {
            e.printStackTrace();
            System.exit(1);
        }
        return this;
    }

    public void executing(String[] args) {
        try {
            TaskProducer tasks = Fluentness.getFlow().getProducer(TaskProducer.class);

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
            e.printStackTrace();
        }
    }


    protected abstract void defineBase(BaseDefinition definition) throws DefinitionException;

    protected abstract void defineData(DataDefinition definition) throws DefinitionException;

    protected abstract void defineFlow(FlowDefinition definition) throws DefinitionException;
}
