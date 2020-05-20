package org.fluentness;

import org.fluentness.controller.AbstractConsoleController;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public abstract class AbstractConsoleApplication implements Application {

    private final Map<Class<? extends AbstractConsoleController>, AbstractConsoleController> controllers;
    private final Map<String, Method> nameActionMap = new HashMap<>();

    public AbstractConsoleApplication(AbstractConsoleController... controllers) {
        Arrays.stream(controllers).forEach(controller ->
            Arrays.stream(controller.getActions()).forEach(action ->
                nameActionMap.put(action.getName(), action)
            )
        );
        this.controllers = Arrays.stream(controllers)
            .collect(Collectors.toMap(AbstractConsoleController::getClass, controller -> controller));
    }

    @Override
    public final void run(String[] args) throws Exception {
        if (args == null) throw new IllegalArgumentException("Passed args array was null");
        String name = args.length == 0 || !nameActionMap.containsKey(args[0]) ? "help" : args[0];
        Method toExecute = nameActionMap.get(name);
        toExecute.setAccessible(true);
        toExecute.invoke(controllers.get(toExecute.getDeclaringClass()));
    }
}
