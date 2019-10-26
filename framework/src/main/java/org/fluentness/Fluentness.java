package org.fluentness;

import org.fluentness.controller.Controller;
import org.fluentness.controller.console.ConsoleController;
import org.fluentness.repository.Repository;
import org.fluentness.service.Service;

import java.lang.reflect.Method;
import java.util.Arrays;

import static org.fluentness.controller.console.AnsiColor.*;

public enum Fluentness {
    does;

    public void inject(String packageName) {
        try {
            DependencyInjector.does.inject(AutoLoader.does.load(packageName + ".service", Service.class));
            DependencyInjector.does.inject(AutoLoader.does.load(packageName + ".repository", Repository.class));
            DependencyInjector.does.inject(AutoLoader.does.load(packageName + ".controller", Controller.class));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void invoke(String[] args) {
        try {
            if (args.length == 0 || args[0].equals("help")) {
                printHelp(DependencyInjector.does.getInstances(ConsoleController.class));
            } else {
                String name = args[0];
                for (ConsoleController controller : DependencyInjector.does.getInstances(ConsoleController.class)) {
                    Method toExecute = Arrays.stream(controller.getActions())
                            .filter(method -> method.getName().equals(name))
                            .findFirst()
                            .orElseThrow(() -> new ConsoleException("No console action %s found", name));
                    toExecute.invoke(controller);
//                if (declaredArguments.length != args.length - 1) {
//                    throw new ConsoleException("Wrong use of console action %s, expected %s arguments, got %s",
//                            taskToExecute.getName(),
//                            declaredArguments.length,
//                            args.length - 1
//                    );
//                }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void printHelp(ConsoleController[] consoleControllers) {

        System.out.println("\n" +
                " _______                                \n" +
                "(  /  //             _/_                \n" +
                " -/--// , , _  _ _   /  _ _   _  (   (  \n" +
                "_/  (/_(_/_(/_/ / /_(__/ / /_(/_/_)_/_)_\n");

        System.out.println(ANSI_GREEN + "Available console actions:\n" + ANSI_RESET);
        System.out.println(Fluentness.class.getPackage().getImplementationVersion());

        for (ConsoleController consoleController : consoleControllers) {
            for (Method action : consoleController.getActions()) {
                String[] arguments = consoleController.getArguments(action);
                String inlineArguments = arguments.length > 0 ? " " + Arrays.toString(arguments) : "";
                System.out.println(String.format(ANSI_PURPLE + "%-30s" + ANSI_RESET + "%s",
                        "    " + action.getName() + inlineArguments,
                        consoleController.getDescription(action)
                ));

            }
        }
//
//        for (Task task : category.getValue()) {
//            String args = task.getArguments().length > 0 ? " " + Arrays.toString(task.getArguments()) : "";
//            System.out.println(String.format(ANSI_PURPLE + "%-30s" + ANSI_RESET + "%s",
//                    "    " + task.getName() + args,
//                    task.getDescription()
//            ));
//        }
//
//

//        for (Map.Entry<String, List<Task>> category : getAllTasksGroupedByCategory().entrySet()) {
//
//            if (category.getValue().size() == 1) {
//                Task task = category.getValue().get(0);
//                String args = task.getArguments().length > 0 ? " " + Arrays.toString(task.getArguments()) : "";
//                System.out.println(String.format(ANSI_BLUE + "%-30s" + ANSI_RESET + "%s",
//                        task.getName() + args, task.getDescription()));
//            } else {
//                System.out.println(String.format(ANSI_BLUE + "%-30s" + ANSI_RESET, category.getKey()));
//                for (Task task : category.getValue()) {
//                    String args = task.getArguments().length > 0 ? " " + Arrays.toString(task.getArguments()) : "";
//                    System.out.println(String.format(ANSI_PURPLE + "%-30s" + ANSI_RESET + "%s",
//                            "    " + task.getName() + args,
//                            task.getDescription()
//                    ));
//                }
//            }
//        }

    }

    static class ConsoleException extends AbstractException {

        ConsoleException(String stringToFormat, Object... parameters) {
            super(stringToFormat, parameters);
        }
    }
}