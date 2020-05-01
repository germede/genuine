package org.fluentness;

import org.fluentness.controller.Controller;
import org.fluentness.controller.console.AbstractConsoleController;
import org.fluentness.controller.console.FluentnessController;
import org.fluentness.controller.desktop.AbstractDesktopController;
import org.fluentness.service.Service;
import org.fluentness.service.authentication.DefaultAuthentication;
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

public final class Fluentness {

    private static final Map<Class, Object> instances = new LinkedHashMap<>();
    private static final List<Class<? extends Service>> defaultServices = Arrays.asList(
            JulLog.class, SocketMail.class, FilePersistence.class, SunServer.class, DefaultConfiguration.class, DefaultTranslator.class, DefaultAuthentication.class
    );
    private static final List<Class<? extends Controller>> defaultControllers = Collections.singletonList(FluentnessController.class);

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
                    Map<Class, Object> instances1 = instances;
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

    private Fluentness(Application application) throws FluentnessException {
        inject(application.getServices());
        inject(defaultServices);
        inject(application.getRepositories());
        inject(application.getControllers());
        inject(defaultControllers);
    }

    private <I extends ApplicationComponent> void inject(List<Class<? extends I>> classes) throws
            FluentnessException {
        List<Class<? extends I>> notInstantiated = new LinkedList<>();
        for (Class<? extends I> clazz : classes) {
            Class key = getKey(clazz);
            if (!instances.containsKey(key)) {
                Object instantiate = instantiate(clazz);
                if (instantiate instanceof Class) {
                    if (classes.contains(instantiate)) {
                        notInstantiated.add(clazz);
                    } else {
                        throw new FluentnessException(
                                "Cannot resolve %s's dependency on %s",
                                clazz.getSimpleName(),
                                ((Class) instantiate).getSimpleName()
                        );
                    }
                } else {
                    instances.put(key, instantiate);
                }
            }
        }
        if (notInstantiated.size() > 0) {
            inject(notInstantiated);
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

    private Object instantiate(Class aClass) throws FluentnessException {
        validate(aClass);
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
                    result[i] = getInstance((Class<? extends ApplicationComponent>) type);
                } else {
                    return type;
                }
            }
            return constructor.newInstance(result);
        } catch (IllegalAccessException | InvocationTargetException | InstantiationException e) {
            throw new FluentnessException(e);
        }
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
}