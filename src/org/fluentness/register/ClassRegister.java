package org.fluentness.register;

import org.fluentness.Fluentness;
import org.fluentness.command.Command;
import org.fluentness.controller.Controller;
import org.fluentness.localization.Localization;
import org.fluentness.logging.Logger;
import org.fluentness.model.Model;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public final class ClassRegister {

    public static final String MODEL = "model";
    public static final String VIEW = "view";
    public static final String CONTROLLER = "controller";
    public static final String LOCALIZATION = "localization";
    public static final String COMMAND = "command";

    // models
    private static Map<String, Model> modelInstances;
    private static Map<String, Model.Properties> modelPropertiesInstances;
    static {
        modelInstances = new HashMap<>();
        modelPropertiesInstances = new HashMap<>();
        for (Class modelClass : getExternalClasses(MODEL, Model.class)) {
            try {
                Model model = (Model) modelClass.newInstance();
                modelInstances.put(model.getClass().getCanonicalName(),model);
                modelPropertiesInstances.put(model.getClass().getCanonicalName(),model.getProperties());
            } catch (InstantiationException | IllegalAccessException e) {
                Logger.error(ClassRegister.class, e);
            }
        }
    }
    public static Model getModelInstance(String className) {
        return modelInstances.get(className);
    }
    public static Model.Properties getModelPropertiesInstance(String className) {
        return modelPropertiesInstances.get(className);
    }

    // controllers
    private static Set<Controller> controllerInstances;
    static {
        controllerInstances = new HashSet<>();
        for (Class controllerClass : getExternalClasses(CONTROLLER, Controller.class)) {
            try {
                controllerInstances.add((Controller) controllerClass.newInstance());
            } catch (InstantiationException | IllegalAccessException e) {
                Logger.error(ClassRegister.class, e);
            }
        }
    }
    public static Set<Controller> getControllerInstances() {
        return controllerInstances;
    }

    // localizations
    private static Map<String, Localization.Translations> translations;
    static {
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
    public static Localization.Translations getTranslation(String language) {
        return translations.get(language);
    }

    // commands
    private static List<Command> commandInstances;
    static {
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
    public static List<Command> getCommandInstances() {
        return commandInstances;
    }

    // class loader
    private static List<Class<?>> getAllClasses(String packageName, Class<?> parent) {
        List<Class<?>> result = getInternalClasses(packageName, parent);
        result.addAll(getExternalClasses(packageName, parent));
        return result;
    }

    // class loader within fluentness
    private static List<Class<?>> getInternalClasses(String packageName, Class<?> parent) {
        packageName = Fluentness.class.getPackage().getName().concat(".").concat(packageName);
        return getClasses(packageName, parent);
    }

    // class loader outside fluentness
    private static List<Class<?>> getExternalClasses(String packageName, Class<?> parent) {
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
            Logger.error(ClassRegister.class, e);
        }
        return result;
    }
}
