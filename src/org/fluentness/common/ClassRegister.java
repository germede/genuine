package org.fluentness.common;

import org.fluentness.Fluentness;
import org.fluentness.command.Command;
import org.fluentness.controller.Controller;
import org.fluentness.localization.Localization;
import org.fluentness.logging.Logger;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class ClassRegister {

    public static final String CONTROLLER = "controller";
    public static final String LOCALIZATION = "localization";
    public static final String COMMAND = "command";

    // commands
    private static List<Command> commandInstances;

    public static List<Command> getCommandInstances() {
        if (commandInstances == null) {
            commandInstances = new ArrayList<>();
            for (Class commandClass : getAllClasses(COMMAND, Command.class)) {
                try {
                    commandInstances.add((Command) commandClass.newInstance());
                } catch (InstantiationException | IllegalAccessException e) {
                    Logger.error(ClassRegister.class, e);
                }
            }
            commandInstances.sort(Comparator.comparing(Command::getName));
        }
        return commandInstances;
    }

    // controllers
    private static Set<Controller> controllerInstances;

    public static Set<Controller> getControllerInstances() {
        if (controllerInstances == null) {
            controllerInstances = new HashSet<>();
            for (Class controllerClass : getExternalClasses(CONTROLLER, Controller.class)) {
                try {
                    Controller controller = (Controller) controllerClass.newInstance();
                    controllerInstances.add(controller);
                } catch (InstantiationException | IllegalAccessException e) {
                    Logger.error(ClassRegister.class, e);
                }
            }
        }
        return controllerInstances;
    }

    // translations
    private static Map<String, Localization.Translations> translations;

    public static Map<String, Localization.Translations> getTranslations() {
        if (translations == null) {
            translations = new HashMap<>();
            for (Class translationClass : getExternalClasses(LOCALIZATION, Localization.class)) {
                try {
                    Localization translationInstance = (Localization) translationClass.newInstance();
                    translations.put(translationInstance.getLanguage().toLowerCase(), translationInstance.getTranslations());
                } catch (InstantiationException | IllegalAccessException e) {
                    Logger.error(ClassRegister.class, e);
                }
            }
        }
        return translations;
    }

    // class loader
    private static List<Class<?>> getAllClasses(String packageName, Class<?> parent) {
        List<Class<?>> result = getInternalClasses(packageName, parent);
        result.addAll(getExternalClasses(packageName, parent));
        return result;
    }

    private static List<Class<?>> getInternalClasses(String packageName, Class<?> parent) {
        packageName = Fluentness.class.getPackage().getName().concat(".").concat(packageName);
        return getClasses(packageName, parent);
    }

    private static List<Class<?>> getExternalClasses(String packageName, Class<?> parent) {
        packageName = Configuration.getString(Configuration.APP_PACKAGE).concat(".").concat(packageName);
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
            Logger.error(ClassRegister.class, e);
        }
        return result;
    }
}
