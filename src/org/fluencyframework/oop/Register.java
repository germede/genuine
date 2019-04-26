package org.fluencyframework.oop;

import org.fluencyframework.cli.Command;
import org.fluencyframework.Configuration;
import org.fluencyframework.lan.Translation;
import org.fluencyframework.lan.Translations;
import org.fluencyframework.log.Logger;
import org.fluencyframework.mvc.Controller;
import org.reflections.Reflections;

import java.util.*;

public class Register {

    // commands
    private static Set<Command> commandInstances;

    public static Set<Command> getCommandInstances() {
        if (commandInstances == null) {
            commandInstances = new HashSet<>();
            for (Class commandClass : getCommandClasses()){
                try {
                    commandInstances.add((Command) commandClass.newInstance());
                } catch (InstantiationException | IllegalAccessException e) {
                    Logger.e(e);
                }
            }
        }
        return commandInstances;
    }

    private static List<Class<? extends Command>> getCommandClasses() {
        // fwf commands
        Reflections reflections = new Reflections("org.fluentworkflow.cli");
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
                    Injector.injectFields(controller);
                    controllerInstances.add(controller);
                } catch (InstantiationException | IllegalAccessException e) {
                    Logger.e(e);
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
                    Translation translation = (Translation) translationClass.newInstance();
                    Injector.injectFields(translationClass);
                    Translation translationInstance = (Translation) translationClass.newInstance();
                    String language = translationClass.getSimpleName().replace("Translation","").toLowerCase();
                    translations.put(language, translationInstance.getTranslations());
                } catch (InstantiationException | IllegalAccessException e) {
                    Logger.e(e);
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
