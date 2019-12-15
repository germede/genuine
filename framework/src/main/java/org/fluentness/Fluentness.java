package org.fluentness;

import org.fluentness.controller.Controller;
import org.fluentness.controller.console.AbstractConsoleController;
import org.fluentness.controller.console.ConsoleAction;
import org.fluentness.controller.console.ConsoleException;
import org.fluentness.controller.desktop.AbstractDesktopController;
import org.fluentness.controller.desktop.DesktopView;
import org.fluentness.injector.Injector;
import org.fluentness.server.Server;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.LinkedList;
import java.util.List;

public class Fluentness {

    public static void launch(Application application, String[] args) throws FluentnessException {
        if (application == null) {
            throw new FluentnessException("Passed application was null");
        }

        try {
            Injector injector = application.getInjector().getConstructor(Application.class).newInstance(application);
            switch (application.getPlatform()) {
                case DESKTOP:
                    desktop(injector);
                    break;
                case WEB:
                    web(injector);
                    break;
                case CONSOLE:
                case MOBILE:
                default:
                    console(injector, args);
            }

        } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
            throw new FluentnessException(e);
        }
    }

    private static void console(Injector injector, String[] args) throws FluentnessException {
        try {
            if (args == null) {
                throw new ConsoleException("Passed args was null");
            }
            String name = args.length == 0 ? "help" : args[0];
            List<ConsoleAction> actions = new LinkedList<>();
            injector.getInstances(AbstractConsoleController.class)
                    .forEach(abstractConsoleController -> actions.addAll(abstractConsoleController.getActions()));
            Method toExecute = actions
                    .stream()
                    .filter(action -> action.getMethod().getName().equals(name))
                    .map(ConsoleAction::getMethod)
                    .findFirst()
                    .orElseThrow(() -> new ConsoleException("No such command with name %s found", name));
            Class<? extends Controller> declaringClass = (Class<? extends Controller>) toExecute.getDeclaringClass();
            toExecute.setAccessible(true);
            toExecute.invoke(injector.getInstance(declaringClass));
        } catch (ConsoleException | IllegalAccessException | InvocationTargetException e) {
            throw new FluentnessException(e);
        }
    }

    private static void desktop(Injector injector) throws FluentnessException {
        try {
            for (AbstractDesktopController controller : injector.getInstances(AbstractDesktopController.class)) {
                DesktopView.setGlobalStyle(controller.getDesktop().getStyle());
                controller.getDesktop().getView().render();
            }
        } catch (Exception e) {
            throw new FluentnessException(e);
        }
    }

    private static void web(Injector injector) {
        injector.getInstance(Server.class).start();
    }


    private Fluentness() {
    }
}