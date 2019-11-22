package org.fluentness.service.loader;

import org.fluentness.ApplicationComponent;
import org.fluentness.Fluentness;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.LinkedList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class DefaultLoader implements Loader {

    @Override
    public <T extends ApplicationComponent> List<Class<? extends T>> load(String packageName, Class<T> parent) throws LoaderException {
        List<Class<? extends T>> result = loadClassFilesInDirectory(packageName, parent);
        result.addAll(loadClassesInJarFile(packageName, parent));
        return result;
    }

    private <T> List<Class<? extends T>> loadClassFilesInDirectory(String packageName, Class<T> parent) throws LoaderException {

        List<Class<? extends T>> result = new LinkedList<>();
        URL root = Thread.currentThread().getContextClassLoader().getResource(packageName.replace(".", "/"));
        if (root != null) {
            File[] files = new File(root.getFile()).listFiles((dir, name) -> name.endsWith(".class"));
            if (files != null) {
                for (File file : files) {
                    try {
                        String className = file.getName().replaceAll(".class$", "");
                        Class<?> clazz = Class.forName(packageName + "." + className);
                        if (parent.isAssignableFrom(clazz) && !clazz.isInterface()) {
                            result.add((Class<T>) clazz);
                        }
                    } catch (ClassNotFoundException e) {
                        throw new LoaderException(e);
                    }
                }
            }
        }
        return result;
    }

    private <T> List<Class<? extends T>> loadClassesInJarFile(String packageName, Class<T> parent) throws LoaderException {

        List<Class<? extends T>> result = new LinkedList<>();
        try {
            String jarPath = new File(Fluentness.class.getProtectionDomain().getCodeSource().getLocation().toURI()).getPath();
            if (jarPath.endsWith(".jar")) {

                ZipInputStream zip = new ZipInputStream(new FileInputStream(jarPath));
                for (ZipEntry entry = zip.getNextEntry(); entry != null; entry = zip.getNextEntry()) {
                    if (!entry.isDirectory() && entry.getName().endsWith(".class") && entry.getName().startsWith(packageName.replace(".", "/"))) {
                        String className = entry.getName().replace('/', '.').replaceAll(".class$", "");
                        Class<?> clazz = Class.forName(className);
                        if (parent.isAssignableFrom(clazz) && !clazz.isInterface()) {
                            result.add((Class<T>) clazz);
                        }
                    }
                }
            }
        } catch (IOException | ClassNotFoundException | URISyntaxException e) {
            throw new LoaderException(e);
        }
        return result;
    }
}
