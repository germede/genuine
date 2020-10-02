package org.fluentness.application;

import org.fluentness.controller.ConsoleController;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public abstract class ConsoleApplication implements Application {

    private final Map<Class, ConsoleController> controllers = new HashMap<>();
    private final Map<String, Method> actions = new HashMap<>();

    public ConsoleApplication(ConsoleController... controllers) {
        Arrays.stream(controllers).forEach(controller -> {
            actions.putAll(controller.getActionMap());
            this.controllers.put(controller.getClass(),controller);
        });
    }

    @Override
    public final void run(String[] args) throws Exception {
        if (args == null) throw new IllegalArgumentException("Passed args array was null");
        String name = args.length == 0 || !actions.containsKey(args[0]) ? "help" : args[0];
        Method toExecute = actions.get(name);
        toExecute.setAccessible(true);
        toExecute.invoke(controllers.get(toExecute.getDeclaringClass()));
    }
}
