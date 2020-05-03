package org.fluentness;

import org.fluentness.controller.console.AbstractConsoleController;
import org.fluentness.controller.desktop.AbstractDesktopController;
import org.fluentness.service.injection.FinalInjection;
import org.fluentness.service.injection.InjectionException;
import org.fluentness.service.server.Server;

import javax.swing.*;
import java.lang.reflect.Method;
import java.util.*;

public final class Fluentness {

    private static Map<Class, Object> instances;

    public static <A extends ApplicationComponent> List<A> getInstances(Class<A> parent) {
        List<A> list = new ArrayList<>();
        for (Object value : instances.values()) {
            if (parent.isAssignableFrom(value.getClass())) {
                list.add((A) value);
            }
        }
        return list;
    }

    public static <A extends ApplicationComponent> A getInstance(Class<A> parent) {
        return (A) instances.get(parent);
    }

    public static Fluentness launch(Application application, String... args) throws FluentnessException {
        return new Fluentness(application, args);
    }

    private Fluentness(Application application, String[] args) throws FluentnessException {
        try {
            instances = new FinalInjection().inject(application);
            switch (application.getPlatform()) {
                case CONSOLE:
                    if (args == null) {
                        throw new IllegalArgumentException("Passed args array was null");
                    }
                    Map<String, Method> nameActionMap = AbstractConsoleController.nameActionMap;
                    String name = args.length == 0 || !nameActionMap.containsKey(args[0]) ? "help" : args[0];
                    Method toExecute = nameActionMap.get(name);
                    toExecute.setAccessible(true);
                    toExecute.invoke(
                        getInstance(
                            (Class<? extends org.fluentness.controller.Controller>) toExecute.getDeclaringClass()
                        )
                    );
                    break;
                case DESKTOP:
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                    List<AbstractDesktopController> instances = getInstances(AbstractDesktopController.class);
                    for (AbstractDesktopController controller : instances) {
//                controller.getDesktop().getStyle().apply();
                        controller.getView().getTemplate().render();
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