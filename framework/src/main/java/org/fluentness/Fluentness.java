package org.fluentness;

import org.fluentness.backbone.architecture.ControllerArchitecture;
import org.fluentness.backbone.architecture.RepositoryArchitecture;
import org.fluentness.backbone.architecture.ServiceArchitecture;
import org.fluentness.backbone.exception.ConsoleActionNotFoundException;
import org.fluentness.backbone.exception.DefinitionException;
import org.fluentness.backbone.exception.InvocationException;
import org.fluentness.backbone.exception.WrongUseOfConsoleActionException;

public final class Fluentness {

    public static void define(ServiceArchitecture.Definer serviceDefiner,
                              RepositoryArchitecture.Definer repositoryDefiner,
                              ControllerArchitecture.Definer repositoryDefiner) {
        try {
            ServiceArchitecture serviceArchitecture = ServiceArchitecture.getInstance();
            serviceDefiner.define(serviceArchitecture);
            serviceArchitecture.disallowDefinition();

            RepositoryArchitecture repositoryArchitecture = RepositoryArchitecture.getInstance();
            repositoryDefiner.define(repositoryArchitecture);
            repositoryArchitecture.disallowDefinition();

            ControllerArchitecture controllerArchitecture = ControllerArchitecture.getInstance();
            repositoryDefiner.define(controllerArchitecture);
            controllerArchitecture.disallowDefinition();
        } catch (DefinitionException e) {
            e.printStackTrace();
        }
    }

    public static void invoke(String[] args) {
        try {
            try {
                String name = args.length == 0 ? "help" : args[0];
                for (org.fluentness.controller.Controller controller : ControllerArchitecture.getInstance().getControllers()) {
                    String[] declaredArguments = new String[0];

                    for (String consoleActionName : controller.getConsoleActions()) {
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