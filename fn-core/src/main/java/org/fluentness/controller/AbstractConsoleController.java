package org.fluentness.controller;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Method;
import java.util.*;
import java.util.stream.Collectors;

import static org.fluentness.service.log.AnsiColor.*;

public abstract class AbstractConsoleController implements Controller {

    @Override
    public final Map<String, Method> getActions() {
        return Arrays.stream(this.getClass().getMethods())
            .filter(method -> method.isAnnotationPresent(Action.class))
            .collect(Collectors.toMap(Method::getName, method -> method));
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

        // categorize console actions
        for (Method action : getActions().values()) {
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
