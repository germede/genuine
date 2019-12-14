package org.fluentness.injector;

import org.fluentness.Fluentness;
import org.fluentness.controller.Controller;
import org.fluentness.repository.CrudRepository;
import org.fluentness.loader.FnLoader;
import org.fluentness.loader.Loader;
import org.fluentness.loader.LoaderException;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Modifier;
import java.lang.reflect.Parameter;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class FnInjector implements Injector {

    private Map<Class, Object> instances = new LinkedHashMap<>();

    public FnInjector(Loader loader) throws InjectorException, LoaderException {

        // add itself and loader service for other classes
        instances.put(Injector.class, this);
        instances.put(FnInjector.class, this);
        instances.put(Loader.class, loader);
        instances.put(FnLoader.class, loader);

        // instantiate application components
        for (Class<? extends Service> service : Fluentness.getApplication().getServices(loader)) {
            inject(service);
        }
        for (Class<? extends CrudRepository> repository : Fluentness.getApplication().getRepositories(loader)) {
            inject(repository);
        }
        for (Class<? extends Controller> controller : Fluentness.getApplication().getControllers(loader)) {
            inject(controller);
        }
    }

    @Override
    public <A> List<A> getInstances(Class<A> parent) {
        return instances.values().stream()
            .filter(value -> parent.isAssignableFrom(value.getClass()))
            .map(o -> (A) o)
            .collect(Collectors.toList());
    }

    @Override
    public <A> A getInstance(Class<A> parent) {
        return (A) instances.get(parent);
    }

    private void inject(Class<? extends Component> cClass) throws InjectorException {
        try {
            validateInstantiation(cClass);

            Constructor[] declaredConstructors = cClass.getDeclaredConstructors();
            Object instance = declaredConstructors.length == 0 ?
                cClass.newInstance() :
                inject(cClass, declaredConstructors[0]);

            instances.put(cClass, instance);

            Arrays.stream(cClass.getInterfaces())
                .filter(Service.class::isAssignableFrom)
                .filter(serviceInterface -> !Service.class.equals(serviceInterface))
                .filter(serviceInterface -> serviceInterface.isAnnotationPresent(Singleton.class))
                .forEach(serviceInterface -> instances.put(serviceInterface, instance));

        } catch (InstantiationException | IllegalAccessException | InvocationTargetException e) {
            throw new InjectorException(e);
        }
    }

    private void validateInstantiation(Class iClass) throws InjectorException {
        if (Modifier.isInterface(iClass.getModifiers())) {
            throw new InjectorException("%s cannot be an interface in order to be instantiated", iClass.getName());
        }
        if (Modifier.isAbstract(iClass.getModifiers())) {
            throw new InjectorException("%s cannot be abstract in order to be instantiated", iClass.getName());
        }
        if (!Modifier.isPublic(iClass.getModifiers())) {
            throw new InjectorException("%s must be public in order to be instantiated", iClass.getName());
        }
        Constructor[] declaredConstructors = iClass.getDeclaredConstructors();
        if (declaredConstructors.length > 1 || !Modifier.isPublic(declaredConstructors[0].getModifiers())) {
            throw new InjectorException("%s may only have one or none public constructor", iClass.getName());
        }
    }

    private Object inject(Class iClass, Constructor constructor)
        throws InjectorException, IllegalAccessException, InvocationTargetException, InstantiationException {

        Parameter[] parameters = constructor.getParameters();
        Object[] parametersToInject = new Object[parameters.length];
        for (int i = 0; i < parameters.length; i++) {
            Class<?> type = parameters[i].getType();
            if (instances.containsKey(type)) {
                parametersToInject[i] = instances.get(type);
            } else {
                if (Component.class.isAssignableFrom(type)) {
                    throw new InjectorException(
                        "Could not resolve dependencies correctly. Ensure that:\n" +
                            "    a) %s is added after %s or\n" +
                            "    b) %s doesn't depend on %s\n",
                        iClass.getSimpleName(),
                        type.getSimpleName(),
                        iClass.getSimpleName(),
                        type.getSimpleName()
                    );
                } else {
                    throw new InjectorException("%s is not an application component", type.getSimpleName());
                }
            }
        }
        return constructor.newInstance(parametersToInject);
    }

}
