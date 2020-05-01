package org.fluentness;

import org.fluentness.controller.console.AbstractConsoleController;
import org.fluentness.controller.desktop.AbstractDesktopController;
import org.fluentness.service.injection.FinalInjection;
import org.fluentness.service.injection.InjectionException;
import org.fluentness.service.server.Server;

import javax.swing.*;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public final class Fluentness {

    private static Map<Class, Object> instances;

    public static <A extends ApplicationComponent> A[] getInstances(Class<A> parent) {
        return (A[]) instances.values().stream()
                .filter(value -> parent.isAssignableFrom(value.getClass()))
                .toArray();
    }

    public static <A extends ApplicationComponent> A getInstance(Class<A> parent) {
        return (A) instances.get(parent);
    }

    public static Fluentness launch(Application application) throws FluentnessException {
        return new Fluentness(application);
    }

    private Fluentness(Application application) throws FluentnessException {
        try {
            instances = new FinalInjection().inject(application);
        } catch (InjectionException e) {
            throw new FluentnessException(e);
        }
    }

    public void on(Application.Platform platform, String... args) throws FluentnessException {
        try {
            switch (platform) {
                case CONSOLE:
                    if (args == null) {
                        throw new IllegalArgumentException("Passed args array was null");
                    }
                    String name = args.length == 0 ? "help" : args[0];
                    List<Method> actions = new LinkedList<>();
                    Arrays.stream(getInstances(AbstractConsoleController.class))
                        .forEach(controller -> actions.addAll(Arrays.asList(controller.getActions())));
                    Method toExecute = actions
                        .stream()
                        .filter(action -> action.getName().equals(name))
                        .findFirst()
                        .orElseThrow(() -> new IllegalArgumentException("No such command with name " + name + " found"));
                    Class<? extends org.fluentness.controller.Controller> declaringClass =
                        (Class<? extends org.fluentness.controller.Controller>) toExecute.getDeclaringClass();
                    toExecute.setAccessible(true);
                    toExecute.invoke(getInstance(declaringClass));
                    break;
                case DESKTOP:
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                    AbstractDesktopController[] instances = getInstances(AbstractDesktopController.class);
                    for (AbstractDesktopController controller : instances) {
//                controller.getDesktop().getStyle().apply();
                        controller.view().getTemplate().render();
                        controller.setListeners();
                    }
                    break;
                case MOBILE:
                case WEB:
                    getInstance(Server.class).start();
            }
        } catch (Throwable cause) {
            throw new FluentnessException(cause);
        }
    }

}