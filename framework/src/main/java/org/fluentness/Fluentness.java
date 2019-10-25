package org.fluentness;

import org.fluentness.base.Base;
import org.fluentness.base.BaseDefiner;
import org.fluentness.base.exception.ConsoleActionNotFoundException;
import org.fluentness.base.exception.DefinitionException;
import org.fluentness.base.exception.InvocationException;
import org.fluentness.base.exception.WrongUseOfConsoleActionException;
import org.fluentness.data.Data;
import org.fluentness.data.DataDefiner;
import org.fluentness.flow.Flow;
import org.fluentness.flow.FlowDefiner;
import org.fluentness.flow.controller.Controller;
import org.fluentness.flow.controller.DefaultController;
import org.fluentness.flow.controller.console.Task;

import java.util.List;

public final class Fluentness {

    private static Fluentness proxy;

    private Fluentness() {
        // instance of the class Fluentness is only used as proxy, avoiding instantiations of base, data and flow
    }

    public static void define(BaseDefiner baseDefiner, DataDefiner dataDefiner, FlowDefiner flowDefiner) {
        proxy = new Fluentness();
        try {
            Base base = Base.getInstance(proxy);
            baseDefiner.define(base);
            base.disallowDefinition();

            Data data = Data.getInstance(proxy);
            dataDefiner.define(data);
            data.disallowDefinition();

            Flow flow = Flow.getInstance(proxy);
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
                for (Controller controller : Flow.getInstance(proxy).getControllers()) {
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