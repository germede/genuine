package org.fluentness;

import org.fluentness.controller.Controller;
import org.fluentness.controller.console.ConsoleAction;
import org.fluentness.controller.console.ConsoleException;
import org.fluentness.controller.desktop.DesktopView;
import org.fluentness.service.injector.Injector;
import org.fluentness.service.server.Server;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.LinkedList;
import java.util.List;

public final class Fluentness {

    public static void launch(Application application, String[] args) throws FluentnessException {
        try {
            Injector injector = application.getInjector().getConstructor(Application.class).newInstance(application);
            switch (application.getPlatform()) {
                case CONSOLE:
                    console(injector, args);
                    break;
                case MOBILE:
                case DESKTOP:
                    desktop(injector);
                    break;
                default:
                    web(injector);
            }
        } catch (Exception e) {
            throw new FluentnessException(e);
        }
    }

    public static void console(Injector injector, String[] args) throws ConsoleException, InvocationTargetException, IllegalAccessException {
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
    }

    public static void desktop(Injector injector) {
        for (AbstractDesktopController controller : injector.getInstances(AbstractDesktopController.class)) {
            DesktopView.setGlobalStyle(controller.getDesktop().getStyle());
            controller.getDesktop().getView().render();
        }
    }

    public static void web(Injector injector) {
        injector.getInstance(Server.class).start();
    }

    private Fluentness() {
    }
}