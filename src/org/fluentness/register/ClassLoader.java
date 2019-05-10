package org.fluentness.register;

import org.fluentness.Fluentness;
import org.fluentness.logging.Logger;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public final class ClassLoader {

    static List<Class<?>> getAllClasses(String packageName, Class<?> parent) {
        List<Class<?>> result = getInternalClasses(packageName, parent);
        result.addAll(getExternalClasses(packageName, parent));
        return result;
    }

    static List<Class<?>> getInternalClasses(String packageName, Class<?> parent) {
        packageName = Fluentness.class.getPackage().getName().concat(".").concat(packageName);
        return getClasses(packageName, parent);
    }

    static List<Class<?>> getExternalClasses(String packageName, Class<?> parent) {
        packageName = Fluentness.Configuration.getString(Fluentness.Configuration.APP_PACKAGE).concat(".").concat(packageName);
        return getClasses(packageName, parent);
    }

    private static List<Class<?>> getClasses(String packageName, Class<?> parent) {
        List<Class<?>> result = new ArrayList<>();
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
                            result.add(clazz);
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
                            result.add(clazz);
                        }
                    }
                }
            }

        } catch (ClassNotFoundException | IOException | URISyntaxException e) {
            Logger.error(ClassLoader.class, e);
        }
        return result;
    }
}
