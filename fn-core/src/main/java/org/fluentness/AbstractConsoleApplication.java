package org.fluentness;

import org.fluentness.controller.AbstractConsoleController;

import java.lang.reflect.Method;
import java.util.Map;

public abstract class AbstractConsoleApplication implements Application {

    @Override
    public final void run(String[] args) throws Exception {
        if (args == null) {
            throw new IllegalArgumentException("Passed args array was null");
        }
        Map<String, Method> nameActionMap = AbstractConsoleController.nameActionMap;
        String name = args.length == 0 || !nameActionMap.containsKey(args[0]) ? "help" : args[0];
        Method toExecute = nameActionMap.get(name);
        toExecute.setAccessible(true);
        toExecute.invoke(
            Fluentness.getInstance(
                (Class<? extends org.fluentness.controller.Controller>) toExecute.getDeclaringClass()
            )
        );
    }
}
