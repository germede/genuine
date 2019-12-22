package org.fluentness;

import org.fluentness.controller.Controller;
import org.fluentness.controller.console.AbstractConsoleController;
import org.fluentness.controller.console.ConsoleAction;
import org.fluentness.controller.console.ConsoleException;
import org.fluentness.controller.desktop.AbstractDesktopController;
import org.fluentness.controller.desktop.DesktopView;
import org.fluentness.service.injector.Injector;
import org.fluentness.service.server.Server;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.LinkedList;
import java.util.List;

public final class Fluentness {

    public static void console(Application application, String[] args) throws FluentnessException {
        try {
            Injector injector = getInjector(application);
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
        } catch (Exception e) {
            throw new FluentnessException(e);
        }
    }

    public static void desktop(Application application) throws FluentnessException {
        try {
            Injector injector = getInjector(application);
            for (AbstractDesktopController controller : injector.getInstances(AbstractDesktopController.class)) {
                DesktopView.setGlobalStyle(controller.getDesktop().getStyle());
                controller.getDesktop().getView().render();
            }
        } catch (Exception e) {
            throw new FluentnessException(e);
        }
    }

    public static void web(Application application) throws FluentnessException {
        try {
            getInjector(application).getInstance(Server.class).start();
        } catch (Exception e) {
            throw new FluentnessException(e);
        }
    }

    private static Injector getInjector(Application application)
        throws InstantiationException, IllegalAccessException, InvocationTargetException, NoSuchMethodException {
        return application.getInjector().getConstructor(Application.class).newInstance(application);
    }


    private Fluentness() {
    }
}