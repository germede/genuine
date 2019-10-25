package org.fluentness;

import org.fluentness.base.exception.ConsoleActionNotFoundException;
import org.fluentness.base.exception.DefinitionException;
import org.fluentness.base.exception.InvocationException;
import org.fluentness.base.exception.WrongUseOfConsoleActionException;
import org.fluentness.flow.Controller;
import org.fluentness.flow.console.Task;

public final class Fluentness {

    public static void define(Base.Definer definer, Data.Definer dataDefiner, Flow.Definer flowDefiner) {
        try {
            Base base = Base.getInstance();
            definer.define(base);
            base.disallowDefinition();

            Data data = Data.getInstance();
            dataDefiner.define(data);
            data.disallowDefinition();

            Flow flow = Flow.getInstance();
            flowDefiner.define(flow);
            flow.disallowDefinition();
        } catch (DefinitionException e) {
            e.printStackTrace();
        }
    }

    public static void invoke(String[] args) {
        try {
            try {
                String name = args.length == 0 ? "help" : args[0];
                for (Controller controller : Flow.getInstance().getControllers()) {
                    String[] declaredArguments = new String[0];

                    for (String consoleActionName: controller.getConsoleActions()) {
                        if (consoleActionName.equals(name)) {
                            if (controller.getClass().getMethod()) {

                            }
                        }
                    }

                    for (Task task : controller.getAllTasks()) {
                        if (name.equals(task.getName())) {
                            taskToExecute = task;
                            declaredArguments = task.getArguments();
                            break;
                        }
                    }

                    if (taskToExecute == null) {
                        throw new ConsoleActionNotFoundException("No console action %s found", name);
                    }

                    if (declaredArguments.length != args.length - 1) {
                        throw new WrongUseOfConsoleActionException("Wrong use of console action %s, expected %s arguments, got %s",
                                taskToExecute.getName(),
                                declaredArguments.length,
                                args.length - 1
                        );
                    }

                    String[] arguments = new String[declaredArguments.length];
                    System.arraycopy(args, 1, arguments, 0, args.length - 1);
                    taskToExecute.execute(arguments);
                }
            } catch (ConsoleActionNotFoundException | WrongUseOfConsoleActionException e) {
                throw new InvocationException(e);
            }
        } catch (InvocationException ex) {
            ex.printStackTrace();
        }
    }
}