package org.fluentness.common;

import org.fluentness.command.Command;
import org.fluentness.Configuration;
import org.fluentness.translation.Translation;
import org.fluentness.translation.Translations;
import org.fluentness.logging.Logger;
import org.fluentness.controller.Controller;
import org.reflections.Reflections;

import java.util.*;

public class ClassRegister {

    // commands
    private static List<Command> commandInstances;

    public static List<Command> getCommandInstances() {
        if (commandInstances == null) {
            commandInstances = new ArrayList<>();
            for (Class commandClass : getCommandClasses()){
                try {
                    commandInstances.add((Command) commandClass.newInstance());
                } catch (InstantiationException | IllegalAccessException e) {
                    Logger.error(e);
                }
            }
            commandInstances.sort(Comparator.comparing(Command::getName));
        }
        return commandInstances;
    }

    private static List<Class<? extends Command>> getCommandClasses() {
        // fwf commands
        Reflections reflections = new Reflections("org.fluentness.cli");
        Set<Class<? extends Command>> result = new HashSet<>(reflections.getSubTypesOf(Command.class));

        // custom commands
        Reflections customReflections = new Reflections(Configuration.get(Configuration.APP_PACKAGE).concat(".commands"));
        result.addAll(customReflections.getSubTypesOf(Command.class));

        // sort commands alphabetically
        List<Class<? extends Command>> sortedCommandClasses = new ArrayList<>(result);
        sortedCommandClasses.sort(Comparator.comparing(Class::getName));

        return sortedCommandClasses;
    }

    // controllers
    private static Set<Controller> controllerInstances;

    public static Set<Controller> getControllerInstances() {
        if (controllerInstances == null) {
            controllerInstances = new HashSet<>();
            for (Class controllerClass : getControllerClasses()){
                try {
                    Controller controller = (Controller) controllerClass.newInstance();
                    controllerInstances.add(controller);
                } catch (InstantiationException | IllegalAccessException e) {
                    Logger.error(e);
                }
            }
        }
        return controllerInstances;
    }

    private static Set<Class<? extends Controller>> getControllerClasses() {
        Reflections reflections = new Reflections(Configuration.get(Configuration.APP_PACKAGE).concat(".controllers"));
        return reflections.getSubTypesOf(Controller.class);
    }


    // translations
    private static Map<String, Translations> translations;

    public static Map<String, Translations> getTranslations() {
        if (translations == null) {
            translations = new HashMap<>();
            for (Class translationClass : getTranslationClasses()){
                try {
                    Translation translationInstance = (Translation) translationClass.newInstance();
                    translations.put(translationInstance.getLanguage(), translationInstance.getTranslations());
                } catch (InstantiationException | IllegalAccessException e) {
                    Logger.error(e);
                }
            }
        }
        return translations;
    }

    private static Set<Class<? extends Translation>> getTranslationClasses() {
        Reflections reflections = new Reflections(Configuration.get(Configuration.APP_PACKAGE).concat(".translations"));
        return reflections.getSubTypesOf(Translation.class);
    }



}
