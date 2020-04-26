package org.fluentness;

import org.fluentness.controller.console.AbstractConsoleController;
import org.fluentness.controller.console.FluentnessController;
import org.fluentness.controller.desktop.AbstractDesktopController;
import org.fluentness.controller.web.AbstractWebController;
import org.fluentness.service.Service;
import org.fluentness.service.authentication.BasicAuthentication;
import org.fluentness.service.configuration.DefaultConfiguration;
import org.fluentness.service.log.JulLog;
import org.fluentness.service.mail.SocketMail;
import org.fluentness.service.persistence.FilePersistence;
import org.fluentness.service.server.Server;
import org.fluentness.service.server.SunServer;
import org.fluentness.service.translator.DefaultTranslator;

import javax.swing.*;
import java.lang.reflect.*;
import java.util.*;
import java.util.List;

import static org.fluentness.controller.web.AbstractWebController.Action;

public final class Fluentness {

    private static final Map<Class, Object> instances = new LinkedHashMap<>();

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

    public static Fluentness launch(Application application) throws FluentnessException {
        return new Fluentness(application);
    }

    public void console(String[] args) throws FluentnessException {
        try {
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
        } catch (Throwable cause) {
            throw new FluentnessException(cause);
        }
    }

    public void desktop() throws FluentnessException {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            Map<Class, Object> instances1 = instances;
            AbstractDesktopController[] instances = getInstances(AbstractDesktopController.class);
            for (AbstractDesktopController controller : instances) {
//                controller.getDesktop().getStyle().apply();
                controller.view().getTemplate().render();
                controller.setListeners();
            }
        } catch (Throwable cause) {
            throw new FluentnessException(cause);
        }
    }

    public void web() throws FluentnessException {
        try {
            Map<String, Method> routes = new HashMap<>();
            for (AbstractWebController webController : getInstances(AbstractWebController.class)) {
                for (Method action : webController.getActions()) {
                    Action annotation = action.getAnnotation(Action.class);
                    routes.put(annotation.method() + " " + annotation.path(), action);
                }
            }
            getInstance(Server.class).start(routes);
        } catch (Throwable cause) {
            throw new FluentnessException(cause);
        }
    }

    private Fluentness(Application application) throws FluentnessException {
        inject(application.getServices());
        inject(
            JulLog.class,
            SocketMail.class,
            FilePersistence.class,
            SunServer.class,
            DefaultConfiguration.class,
            DefaultTranslator.class,
            BasicAuthentication.class
        );

        inject(application.getRepositories());

        inject(application.getControllers());
        inject(FluentnessController.class);
    }

    private <I extends ApplicationComponent> void inject(Class<? extends I>... classes) throws FluentnessException {
        for (int i = 0; i < classes.length; i++) {
            for (int j = 0; j < classes.length; j++) {
                Class aClass = classes[j];
                Class key = getKey(aClass);

                // do not override keys when already instantiated
                if (instances.containsKey(key)) {
                    continue;
                }

                validate(aClass);
                Object value = instantiate(aClass);
                if (value != null) {
                    instances.put(key, value);
                }
            }
        }
    }

    private Class<? extends ApplicationComponent> getKey(Class<? extends ApplicationComponent> aClass) {
        if (!Service.class.isAssignableFrom(aClass)) {
            return aClass;
        }
        Class currentClass = aClass;
        while (!currentClass.equals(Object.class)) {
            for (Class anInterface : currentClass.getInterfaces()) {
                if (anInterface.equals(Service.class)) {
                    return currentClass;
                }
                if (Service.class.isAssignableFrom(anInterface)) {
                    return anInterface;
                }
            }
            currentClass = currentClass.getSuperclass();
        }
        return null;
    }

    private void validate(Class aClass) throws FluentnessException {
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
        if (declaredConstructors.length > 0) {
            if (!Modifier.isPublic(declaredConstructors[0].getModifiers())) {
                throw new FluentnessException("%s's first constructor should be public", aClass.getName());
            }

            for (Class parameterType : declaredConstructors[0].getParameterTypes()) {
                if (!ApplicationComponent.class.isAssignableFrom(parameterType)) {
                    throw new FluentnessException("%s constructor parameters should be ApplicationComponent", aClass.getName());
                }
            }
        }
    }

    private Object instantiate(Class aClass) throws FluentnessException {
        try {
            Constructor[] declaredConstructors = aClass.getDeclaredConstructors();
            if (declaredConstructors.length == 0) {
                // no dependencies, just instantiate
                return aClass.newInstance();
            }

            Constructor constructor = declaredConstructors[0];
            Parameter[] parameters = constructor.getParameters();
            Object[] result = new Object[parameters.length];
            for (int i = 0; i < parameters.length; i++) {
                Class<?> type = parameters[i].getType();
                if (instances.containsKey(type)) {
                    // dependency was already instantiated
                    result[i] = getInstance((Class<? extends ApplicationComponent>) type);
                } else {
                    // cancel instantiation
                    return null;
                }
            }
            return constructor.newInstance(result);
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException e) {
            throw new FluentnessException(e);
        }
    }

}