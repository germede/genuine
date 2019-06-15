package org.fluentness;

import org.fluentness.base.generics.Component;
import org.fluentness.base.generics.Register;
import org.fluentness.base.logging.Log;
import org.fluentness.configuration.Configuration;
import org.fluentness.configuration.ConfigurationProducer;
import org.fluentness.controller.ControllerProducer;
import org.fluentness.form.FormProducer;
import org.fluentness.localization.LocalizationProducer;
import org.fluentness.model.ModelProducer;
import org.fluentness.style.StyleProducer;
import org.fluentness.task.Command;
import org.fluentness.task.FTaskProvider;
import org.fluentness.task.Task;
import org.fluentness.task.TaskProducer;
import org.fluentness.view.ViewProducer;

import java.util.Map;

public enum Fluentness {

    INSTANCE;

    public String appPackage;

    public ConfigurationProducer configurations;
    public ControllerProducer controllers;
    public FormProducer forms;
    public LocalizationProducer localizations;
    public ModelProducer models;
    public StyleProducer styles;
    public TaskProducer tasks;
    public ViewProducer views;

    public void initialize(String appPackage, String configurationToApply, String[] programArguments) {
        Log.INSTANCE.configure();
        Fluentness.INSTANCE.appPackage = appPackage;
        initProviders();
        callPlugins();
        applyConfiguration(configurationToApply);
        executeCommand(programArguments);
    }

    private void initProviders() {
        try {


            configurations = (ConfigurationProducer) Class.forName(appPackage + ".Configurations").newInstance();
            localizations = (LocalizationProducer) Class.forName(appPackage + ".Localizations").newInstance();
            models = (ModelProducer) Class.forName(appPackage + ".Models").newInstance();
            styles = (StyleProducer) Class.forName(appPackage + ".Styles").newInstance();
            forms = (FormProducer) Class.forName(appPackage + ".Forms").newInstance();
            views = (ViewProducer) Class.forName(appPackage + ".Views").newInstance();
            tasks = (TaskProducer) Class.forName(appPackage + ".Tasks").newInstance();
            controllers = (ControllerProducer) Class.forName(appPackage + ".Controllers").newInstance();
        } catch (InstantiationException | NullPointerException | IllegalAccessException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void callPlugins() {

    }

    private void applyConfiguration(String configurationName) {
        Configuration configuration = configurations.get(configurationName);
        configuration.apply();
        Log.INSTANCE.configure();

    }

    private void executeCommand(String[] args) {

        Command commandToExecute = null;
        if (args.length == 0) {
            new FTaskProvider().help.getCommands()[0].value().getExecutor().execute(new String[0]);
            System.exit(0);
        }

        for (Map.Entry<String, Command> command : Task.retrieveAllCommands().entrySet()) {
            if (args[0].equals(command.getKey())) {
                commandToExecute = command.getValue();
            }
        }
        if (commandToExecute == null) {
            Log.INSTANCE.error("No command %s found", args[0]);
            System.exit(0);
        }

        String[] declaredParameters = commandToExecute.getParameters();
        if (declaredParameters.length != args.length - 1) {
            Log.INSTANCE.error("Wrong use of command %s, expected %s arguments", args[0], declaredParameters.length);
            System.exit(0);
        }

        String[] parameters = new String[declaredParameters.length];
        System.arraycopy(args, 1, parameters, 0, args.length - 1);
        commandToExecute.getExecutor().execute(parameters);
    }

    public static class OnionHierarchy implements Register<Component, Integer> {

        public static final OnionHierarchy INSTANCE = new OnionHierarchy();

        // Ordering less dependant -> more dependant
        static {
//            map.put("configuration", 0);
//            map.put("localization", 3000);
//            map.put("model", 4000);
//            map.put("style", 5000);
//            map.put("form", 2000);
//            map.put("view", 7000);
//            map.put("task", 6000);
//            map.put("controller", 1000);
        }

        public boolean isOnionDependant(String producedComponentName, String consumedComponentName) {
//            return map.get(producedComponentName.toLowerCase()) <;
            return false;
        }
    }
}
