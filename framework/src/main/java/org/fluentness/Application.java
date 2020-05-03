package org.fluentness;

import org.fluentness.controller.Controller;
import org.fluentness.repository.Repository;
import org.fluentness.service.Service;
import org.fluentness.service.configuration.Setting;

import java.io.File;
import java.net.URL;
import java.util.LinkedList;
import java.util.List;

public interface Application {

    enum Platform {
        CONSOLE,
        DESKTOP,
        MOBILE,
        WEB
    }

    Setting<String> NAME = new Setting<>("Fluentness application");

    default List<Class<? extends Service>> getServices() {
        return load(Service.class);
    }

    default List<Class<? extends Repository>> getRepositories() {
        return load(Repository.class);
    }

    default List<Class<? extends Controller>> getControllers() {
        return load(Controller.class);
    }

    default <T> List<Class<? extends T>> load(Class<T> parent) {
        List<Class<? extends T>> result = new LinkedList<>();
        try {
            String packageName = this.getClass().getPackage().getName() + "." + parent.getSimpleName().toLowerCase();
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
                            result.add((Class<? extends T>) clazz);
                        }
                    }
                }
            }

            // filter .class files in jar file
//            String jarPath = new File(Fluentness.class.getProtectionDomain().getCodeSource().getLocation().toURI()).getPath();
//            if (jarPath.endsWith(".jar")) {
//                ZipInputStream zip = new ZipInputStream(new FileInputStream(jarPath));
//                for (ZipEntry entry = zip.getNextEntry(); entry != null; entry = zip.getNextEntry()) {
//                    if (!entry.isDirectory() && entry.getName().endsWith(".class") && entry.getName().startsWith(path)) {
//                        String className = entry.getName().replace('/', '.').replaceAll(".class$", "");
//                        Class<?> clazz = Class.forName(className);
//                        // find classes implementing parent
//                        if (parent.isAssignableFrom(clazz) && !clazz.isInterface()) {
//                            result.add((Class<? extends T>) clazz);
//                        }
//                    }
//                }
//            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return result;
    }

}
