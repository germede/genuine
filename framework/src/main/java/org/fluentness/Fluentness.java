package org.fluentness;

import org.fluentness.controller.console.AbstractConsoleController;
import org.fluentness.controller.desktop.AbstractDesktopController;
import org.fluentness.service.injection.FinalInjection;
import org.fluentness.service.injection.Injection;
import org.fluentness.service.server.Server;

import javax.swing.*;
import java.lang.reflect.Method;
import java.util.*;

public final class Fluentness {

    public static Fluentness launch(Application application, String... args) throws FluentnessException {
        return new Fluentness(application, args);
    }

    private Fluentness(Application application, String[] args) throws FluentnessException {
        try {
            Application.Platform platform = new FinalInjection().inject(application);
            switch (platform) {
                case CONSOLE:
                    if (args == null) {
                        throw new IllegalArgumentException("Passed args array was null");
                    }
                    Map<String, Method> nameActionMap = AbstractConsoleController.nameActionMap;
                    String name = args.length == 0 || !nameActionMap.containsKey(args[0]) ? "help" : args[0];
                    Method toExecute = nameActionMap.get(name);
                    toExecute.setAccessible(true);
                    toExecute.invoke(
                        Injection.getInstance(
                            (Class<? extends org.fluentness.controller.Controller>) toExecute.getDeclaringClass()
                        )
                    );
                    break;
                case DESKTOP:
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                    List<AbstractDesktopController> instances = Injection.getInstances(AbstractDesktopController.class);
                    for (AbstractDesktopController controller : instances) {
//                controller.getDesktop().getStyle().apply();
                        controller.getView().getTemplate().render();
                        controller.setListeners();
                    }
                    break;
                case MOBILE:
                    // FnActivity initializes the views
                    break;
                case WEB:
                    Injection.getInstance(Server.class).start();
                    break;
            }
        } catch (Throwable cause) {
            throw new FluentnessException(cause);
        }
    }

}