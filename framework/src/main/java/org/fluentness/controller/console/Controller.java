package org.fluentness.controller.console;

import org.fluentness.Fluentness;

import java.lang.annotation.*;
import java.lang.reflect.Method;
import java.util.*;

import static org.fluentness.service.logger.AnsiColor.*;
import static org.fluentness.service.logger.AnsiColor.RESET;

public abstract class Controller implements org.fluentness.controller.Controller {

    @Override
    public Class<? extends Annotation> getActionClass() {
        return Action.class;
    }

    @Target(ElementType.METHOD)
    @Retention(RetentionPolicy.RUNTIME)
    protected @interface Action {
        String description() default "";

        String category() default "";
    }

    @Action(description = "Prints all available console actions")
    public void help() {

        System.out.println("\n"
            + " _______                                \n"
            + "(  /  //             _/_                \n"
            + " -/--// , , _  _ _   /  _ _   _  (   (  \n"
            + "_/  (/_(_/_(/_/ / /_(__/ / /_(/_/_)_/_)_\n"
        );

        System.out.println(GREEN + "Available console actions:" + RESET);

        Map<String, List<String>> categorizedConsoleActions = new TreeMap<>();

        List<Method> actions = new LinkedList<>();
        Arrays.stream(Fluentness.getInstances(org.fluentness.controller.console.Controller.class))
            .forEach(controller -> actions.addAll(Arrays.asList(controller.getActions())));

        // categorize console actions
        for (Method action : actions) {
            String category = action.getAnnotation(Action.class).category();
            if (!categorizedConsoleActions.containsKey(category)) {
                categorizedConsoleActions.put(category, new ArrayList<>());
            }
            String inLineParameters = action.getParameterCount() > 0 ?
                Arrays.stream(action.getParameters())
                    .map(entry -> " [" + entry.getName() + ":" + entry.getType().getSimpleName() + "]")
                    .reduce(String::concat)
                    .get()
                : "";
            String actionLine = String.format(PURPLE + "    %-40s" + RESET + "%s",
                action.getName() + inLineParameters,
                " " + action.getAnnotation(Action.class).description()
            );
            categorizedConsoleActions.get(category).add(actionLine);
        }

        // print console actions
        categorizedConsoleActions.forEach((key, value) -> {
            System.out.println(String.format(BLUE + "%-40s" + RESET, key + (!key.isEmpty() ? ":" : "")));
            value.forEach(System.out::println);
            System.out.println();
        });
    }

}
