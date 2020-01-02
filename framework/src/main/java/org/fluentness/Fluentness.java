package org.fluentness;

import org.fluentness.controller.console.ConsoleAction;
import org.fluentness.controller.console.ConsoleException;
import org.fluentness.controller.desktop.Controller;
import org.fluentness.controller.web.WebAction;
import org.fluentness.service.configuration.Configuration;
import org.fluentness.service.logger.Logger;
import org.fluentness.service.mailer.Mailer;
import org.fluentness.service.persistence.Persistence;
import org.fluentness.service.server.Server;
import org.fluentness.service.translator.Translator;

import java.lang.reflect.*;
import java.util.*;

public final class Fluentness {

    public static Fluentness launch(Application application) {
        return new Fluentness(application);
    }

    private static final Map<Class, Object> instances = new LinkedHashMap<>();

    private Fluentness(Application application) {
        inject(Configuration.class, application.getConfiguration());
        application.configure(getInstance(Configuration.class));

        // basic services
        inject(Translator.class, application.getTranslator());
        inject(Logger.class, application.getLogger());
        inject(Persistence.class, application.getPersistence());
        inject(Server.class, application.getServer());
        inject(Mailer.class, application.getMailer());

        // app components
        inject(application.getServices());
        inject(application.getRepositories());
        inject(application.getControllers());
    }

    public void console(String[] args) {
        if (args == null) {
            throw new IllegalArgumentException("Passed args array was null");
        }
        String name = args.length == 0 ? "help" : args[0];
        List<ConsoleAction> actions = new LinkedList<>();
        Arrays.stream(getInstances(org.fluentness.controller.console.Controller.class))
            .forEach(controller -> actions.addAll(controller.getActions()));
        Method toExecute = actions
            .stream()
            .filter(action -> action.getMethod().getName().equals(name))
            .map(ConsoleAction::getMethod)
            .findFirst()
            .orElseThrow(() -> new ConsoleException("No such command with name %s found", name));
        Class<? extends org.fluentness.controller.Controller> declaringClass = (Class<? extends org.fluentness.controller.Controller>) toExecute.getDeclaringClass();
        toExecute.setAccessible(true);
        toExecute.invoke(getInstance(declaringClass));
    }

    public void desktop() {
        for (Controller controller : getInstances(Controller.class)) {
            DesktopView.setGlobalStyle(controller.getDesktop().getStyle());
            controller.getDesktop().getTemplate().render();
        }
    }

    public void web() {
        Map<String, WebAction> routes = new HashMap<>();
        Arrays.stream(getInstances(org.fluentness.controller.web.Controller.class))
            .forEach(controller -> routes.putAll(controller.getRoutes()));
        getInstance(Server.class).start(routes);
    }

    private <A extends ApplicationComponent> A[] getInstances(Class<A> parent) {
        return (A[]) instances.values().stream()
            .filter(value -> parent.isAssignableFrom(value.getClass()))
            .map(o -> (A) o)
            .toArray();
    }

    public static <A extends ApplicationComponent> A getInstance(Class<A> parent) {
        return (A) instances.get(parent);
    }

    private <A extends ApplicationComponent> void inject(Class<? extends A>... classList) {
        for (Class aClass : classList) {
            instances.put(aClass, instantiate(aClass));
        }
    }

    private <A extends ApplicationComponent> void inject(Class<A> iClass, Class<? extends A> aClass) {
        instances.put(iClass, instantiate(aClass));
    }

    private <A extends ApplicationComponent> A instantiate(Class<? extends A> aClass) {
        try {
            validateInstantiation(aClass);
            Constructor[] declaredConstructors = aClass.getDeclaredConstructors();
            if (declaredConstructors.length == 0) {
                return aClass.newInstance();
            }

            Constructor constructor = declaredConstructors[0];
            return (A) constructor.newInstance(prepareConstructorParameters(aClass, constructor));

        } catch (InstantiationException | IllegalAccessException | InvocationTargetException e) {
            throw new FluentnessException(e);
        }
    }

    private <A extends ApplicationComponent> Object[] prepareConstructorParameters(
        Class<? extends A> aClass, Constructor constructor
    ) {

        Parameter[] parameters = constructor.getParameters();
        Object[] result = new Object[parameters.length];
        for (int i = 0; i < parameters.length; i++) {
            Class<?> type = parameters[i].getType();
            if (instances.containsKey(type)) {
                result[i] = instances.get(type);
            } else {
                if (ApplicationComponent.class.isAssignableFrom(type)) {
                    throw new FluentnessException(
                        "Cannot instantiate % because it cannot depend on %s",
                        aClass.getSimpleName(),
                        type.getSimpleName()
                    );
                } else {
                    throw new FluentnessException("%s is not an application component", type.getSimpleName());
                }
            }
        }
        return result;
    }

    private void validateInstantiation(Class aClass) throws FluentnessException {
        if (Modifier.isInterface(aClass.getModifiers())) {
            throw new FluentnessException("%s's class cannot be an interface in order to be instantiated", aClass.getName());
        }
        if (Modifier.isAbstract(aClass.getModifiers())) {
            throw new FluentnessException("%s's class cannot be abstract in order to be instantiated", aClass.getName());
        }
        if (!Modifier.isPublic(aClass.getModifiers())) {
            throw new FluentnessException("%s's class must be public in order to be instantiated", aClass.getName());
        }
        Constructor[] declaredConstructors = aClass.getDeclaredConstructors();
        if (declaredConstructors.length > 1 || !Modifier.isPublic(declaredConstructors[0].getModifiers())) {
            throw new FluentnessException("%s's first constructor should be public", aClass.getName());
        }
    }
}