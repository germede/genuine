package org.fluentness;

import org.fluentness.controller.Controller;
import org.fluentness.repository.Repository;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.LinkedList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public interface Application {


    static <T> List<Class<? extends T>> autoload(String packageName, Class<T> parent) {
        List<Class<? extends T>> result = new LinkedList<>();
        try {
            // directory
            URL root = Thread.currentThread().getContextClassLoader().getResource(packageName.replace(".", "/"));
            if (root != null) {
                File[] files = new File(root.getFile()).listFiles((dir, name) -> name.endsWith(".class"));
                if (files != null) {
                    for (File file : files) {
                        String className = file.getName().replaceAll(".class$", "");
                        Class<?> clazz = Class.forName(packageName + "." + className);
                        if (parent.isAssignableFrom(clazz) && !clazz.isInterface()) {
                            result.add((Class<T>) clazz);
                        }
                    }
                }
            }

            // jar file
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
            e.printStackTrace();
        }
        return result;
    }


    default String getName() {
        return this.getClass().getSimpleName().replace("Application", "");
    }

    default Platform getPlatform() {
        return Platform.WEB;
    }

    default List<Class<? extends Controller>> getControllers() {
        return autoload(this.getClass().getPackage().getName() + ".controller", Controller.class);
    }

    default List<Class<? extends Repository>> getRepositories() {
        return autoload(this.getClass().getPackage().getName() + ".repository", Repository.class);
    }


}
