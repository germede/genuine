package org.fluentness;

import org.fluentness.controller.console.FluentnessController;
import org.fluentness.controller.desktop.Controller;
import org.fluentness.service.configuration.Configuration;
import org.fluentness.service.logger.Logger;
import org.fluentness.service.mailer.Mailer;
import org.fluentness.service.persistence.Persistence;
import org.fluentness.service.server.Server;
import org.fluentness.service.translator.Translator;

import java.lang.reflect.*;
import java.util.*;

import static org.fluentness.controller.web.Controller.Action;

public final class Fluentness {

    private static final Map<Class, Object> instances = new LinkedHashMap<>();

    public static Fluentness launch(Application application) throws FluentnessException {
        return new Fluentness(application);
    }

    public static <A extends ApplicationComponent> A[] getInstances(Class<A> parent) {
        Object[] objects = instances.values().stream()
            .filter(value -> parent.isAssignableFrom(value.getClass()))
            .toArray();
        A[] result = (A[]) Array.newInstance(parent, objects.length);
        for (int j = 0; j < objects.length; j++) {
            Array.set(result, j, objects[j]);
        }
        return result;
    }

    public static <A extends ApplicationComponent> A getInstance(Class<A> parent) {
        return (A) instances.get(parent);
    }

    private Fluentness(Application application) throws FluentnessException {
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
        inject(FluentnessController.class, FluentnessController.class);
        inject(application.getControllers());
    }

    public void console(String[] args) throws FluentnessException {
        try {
            if (args == null) {
                throw new IllegalArgumentException("Passed args array was null");
            }
            String name = args.length == 0 ? "help" : args[0];
            List<Method> actions = new LinkedList<>();
            Arrays.stream(getInstances(org.fluentness.controller.console.Controller.class))
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
        } catch (Throwable cause) {
            throw new FluentnessException(cause);
        }
    }

    public void desktop() throws FluentnessException {
        try {
            for (Controller controller : getInstances(Controller.class)) {
//                controller.getDesktop().getStyle().apply();
                controller.getDesktop().getTemplate().render();
            }
        } catch (Throwable cause) {
            throw new FluentnessException(cause);
        }
    }

    public void web() throws FluentnessException {
        try {
            Map<String, Method> routes = new HashMap<>();
            for (org.fluentness.controller.web.Controller controller : getInstances(org.fluentness.controller.web.Controller.class)) {
                for (Method action : controller.getActions()) {
                    Action annotation = action.getAnnotation(Action.class);
                    routes.put(annotation.method() + " " + annotation.path(), action);
                }
            }

            getInstance(Server.class).start(routes);
        } catch (Throwable cause) {
            throw new FluentnessException(cause);
        }
    }

    private <I extends ApplicationComponent> void inject(Class<? extends I>... classList) throws FluentnessException {
        for (Class aClass : classList) {
            instances.put(aClass, instantiate(aClass));
        }
    }

    private <I extends ApplicationComponent> void inject(Class<I> iClass, Class<? extends I> aClass) throws FluentnessException {
        instances.put(iClass, instantiate(aClass));
    }

    private <I extends ApplicationComponent> I instantiate(Class<? extends I> aClass) throws FluentnessException {
        try {
            validateInstantiation(aClass);
            Constructor[] declaredConstructors = aClass.getDeclaredConstructors();
            if (declaredConstructors.length == 0) {
                return aClass.newInstance();
            }

            Constructor constructor = declaredConstructors[0];
            return (I) constructor.newInstance(prepareConstructorParameters(aClass, constructor));
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException e) {
            throw new FluentnessException(e);
        }
    }

    private <I extends ApplicationComponent> Object[] prepareConstructorParameters(
        Class<? extends I> aClass,
        Constructor constructor
    ) throws FluentnessException {

        Parameter[] parameters = constructor.getParameters();
        Object[] result = new Object[parameters.length];
        for (int i = 0; i < parameters.length; i++) {
            Class<?> type = parameters[i].getType();
            if (ApplicationComponent[].class.isAssignableFrom(type)) {
                result[i] = getInstances((Class<? extends ApplicationComponent>) type.getComponentType());
            } else if (instances.containsKey(type)) {
                result[i] = getInstance((Class<? extends ApplicationComponent>) type);
            } else {
                if (ApplicationComponent.class.isAssignableFrom(type)) {
                    throw new FluentnessException(
                        "Cannot instantiate % because it cannot depend on %s",
                        aClass.getSimpleName(),
                        type.getSimpleName()
                    );
                } else {
                    throw new FluentnessException("%s is not injectable as it isn't any ApplicationComponent", type.getSimpleName());
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