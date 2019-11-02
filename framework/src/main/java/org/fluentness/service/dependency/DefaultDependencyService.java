package org.fluentness.service.dependency;

import org.fluentness.Fluentness;
import org.fluentness.service.Service;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Modifier;
import java.lang.reflect.Parameter;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public final class DefaultDependencyService implements DependencyService {

    private Map<Class, Object> instances = new LinkedHashMap<>();

    public DefaultDependencyService() {
        // add itself as first dependency for other classes
        instances.put(DependencyService.class, this);
    }

    @Override
    public <T> List<T> getInstances(Class<T> parent) {
        List<T> result = new ArrayList<>();
        for (Object value : instances.values()) {
            if (parent.isAssignableFrom(value.getClass())) {
                result.add((T) value);
            }
        }
        return result;
    }

    @Override
    public <T> T getInstance(Class<T> tClass) {
        return (T) instances.get(tClass);
    }

    @Override
    public <T> void inject(List<Class<? extends T>> classes) throws InjectionException {
        for (Class aClass : classes) {
            inject(aClass);
        }
    }

    @Override
    public <T> List<Class<? extends T>> loadClasses(String packageName, Class<T> parent) throws ClassLoadingException {
        List<Class<? extends T>> result = new LinkedList<>();
        try {
            String path = packageName.replace(".", "/");
            URL root = Thread.currentThread().getContextClassLoader().getResource(path);

            // filter .class files in project directory
            if (root != null) {
                File[] files = new File(root.getFile()).listFiles((dir, name) -> name.endsWith(".class"));
                if (files != null) {
                    for (File file : files) {
                        String className = file.getName().replaceAll(".class$", "");
                        Class<?> clazz = Class.forName(packageName + "." + className);
                        // find classes implementing parent
                        if (parent.isAssignableFrom(clazz) && !clazz.isInterface()) {
                            result.add((Class<T>) clazz);
                        }
                    }
                }
            }

            // filter .class files in jar file
            String jarPath = new File(Fluentness.class.getProtectionDomain().getCodeSource().getLocation().toURI()).getPath();
            if (jarPath.endsWith(".jar")) {
                ZipInputStream zip = new ZipInputStream(new FileInputStream(jarPath));
                for (ZipEntry entry = zip.getNextEntry(); entry != null; entry = zip.getNextEntry()) {
                    if (!entry.isDirectory() && entry.getName().endsWith(".class") && entry.getName().startsWith(path)) {
                        String className = entry.getName().replace('/', '.').replaceAll(".class$", "");
                        Class<?> clazz = Class.forName(className);
                        // find classes implementing parent
                        if (parent.isAssignableFrom(clazz) && !clazz.isInterface()) {
                            result.add((Class<T>) clazz);
                        }
                    }
                }
            }

        } catch (ClassNotFoundException | IOException | URISyntaxException e) {
            throw new ClassLoadingException(e);
        }
        return result;
    }

    private void inject(Class aClass) throws InjectionException {
        validateInstantiation(aClass);
        instantiate(aClass);
    }

    private void validateInstantiation(Class iClass) throws InjectionException {
        if (Modifier.isInterface(iClass.getModifiers())) {
            throw new InjectionException("%s cannot be an interface in order to be instantiated", iClass.getName());
        }
        if (Modifier.isAbstract(iClass.getModifiers())) {
            throw new InjectionException("%s cannot be abstract in order to be instantiated", iClass.getName());
        }
        if (!Modifier.isPublic(iClass.getModifiers())) {
            throw new InjectionException("%s must be public in order to be instantiated", iClass.getName());
        }
        Constructor[] declaredConstructors = iClass.getDeclaredConstructors();
        if (declaredConstructors.length > 1 || !Modifier.isPublic(declaredConstructors[0].getModifiers())) {
            throw new InjectionException("%s may only have one or none public constructor", iClass.getName());
        }
    }

    private void instantiate(Class iClass) throws InjectionException {
        // if service don't use implementation class but interface
        Class instanceKey = Service.class.isAssignableFrom(iClass) ? getInterfaceForServiceClass(iClass) : iClass;

        // don't override implementations
        if (instances.containsKey(instanceKey)) {
            return;
        }

        try {
            // it no constructor, instantiate it directly without parameters
            Constructor[] declaredConstructors = iClass.getDeclaredConstructors();
            if (declaredConstructors.length == 0) {
                instances.put(instanceKey, iClass.newInstance());
            } else {
                // otherwise inject dependencies
                Parameter[] parameters = declaredConstructors[0].getParameters();
                Object[] parametersToInject = new Object[parameters.length];
                for (int i = 0; i < parameters.length; i++) {
                    Parameter parameter = parameters[i];
                    if (instances.containsKey(parameter.getType())) {
                        parametersToInject[i] = instances.get(parameter.getType());
                    } else {
                        inject(parameter.getType());
                        i--;
                    }
                }
                instances.put(instanceKey, declaredConstructors[0].newInstance(parametersToInject));
            }

        } catch (InstantiationException | IllegalAccessException | InvocationTargetException e) {
            throw new InjectionException(e);
        }
    }

    private Class getInterfaceForServiceClass(Class<? extends Service> sClass) {
        // service interface is directly implemented
        for (Class sClassInterface : sClass.getInterfaces()) {
            if (sClassInterface.equals(Service.class)) {
                return sClass;
            }
            if (Service.class.isAssignableFrom(sClassInterface)) {
                return sClassInterface;
            }
        }
        // retrieve interface recursively through the super classes
        Class superClass = sClass.getSuperclass();
        while (superClass != Object.class) {
            for (Class superClassInterface : superClass.getInterfaces()) {
                if (Service.class.isAssignableFrom(superClassInterface)) {
                    return superClassInterface;
                }
            }
            superClass = superClass.getSuperclass();
        }
        return sClass;
    }

}
