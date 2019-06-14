package org.fluentness;

import org.fluentness.base.generics.Register;
import org.fluentness.base.logging.Log;
import org.fluentness.configuration.ConfigurationProvider;
import org.fluentness.controller.ControllerProvider;
import org.fluentness.form.FormProvider;
import org.fluentness.localization.LocalizationProvider;
import org.fluentness.model.ModelProvider;
import org.fluentness.style.StyleProvider;
import org.fluentness.task.Command;
import org.fluentness.task.TaskProvider;
import org.fluentness.task.TaskProviderImpl;
import org.fluentness.view.ViewProvider;

import java.util.Map;

public class Fluentness<
    Configurations extends ConfigurationProvider,
    Controllers extends ControllerProvider,
    Forms extends FormProvider,
    Localizations extends LocalizationProvider,
    Models extends ModelProvider,
    Styles extends StyleProvider,
    Tasks extends TaskProvider,
    Views extends ViewProvider
    >
    implements Register<String, Object> {

    Class<Configurations> configurationProviderClass;
    Class<Controllers> controllerProviderClass;
    Class<Forms> formProviderClass;
    Class<Localizations> localizationProviderClass;
    Class<Models> modelProviderClass;
    Class<Styles> styleProviderClass;
    Class<Tasks> taskProviderClass;
    Class<Views> viewProviderClass;

    public Configurations configurations;
    public Controllers controllers;
    public Forms forms;
    public Localizations localizations;
    public Models models;
    public Styles styles;
    public Tasks tasks;
    public Views views;

    public static Fluentness get;

    public Fluentness(
        Class<Configurations> configurationProviderClass,
        Class<Controllers> controllerProviderClass,
        Class<Forms> formProviderClass,
        Class<Localizations> localizationProviderClass,
        Class<Models> modelProviderClass,
        Class<Styles> styleProviderClass,
        Class<Tasks> taskProviderClass,
        Class<Views> viewProviderClass
    ) {
        this.configurationProviderClass = configurationProviderClass;
        this.controllerProviderClass = controllerProviderClass;
        this.formProviderClass = formProviderClass;
        this.localizationProviderClass = localizationProviderClass;
        this.modelProviderClass = modelProviderClass;
        this.styleProviderClass = styleProviderClass;
        this.taskProviderClass = taskProviderClass;
        this.viewProviderClass = viewProviderClass;
        get = this;
    }



    public Step.Zero Fluentness() {
         return new Step.Zero();
    }
    public class Step {

        public class Zero {

        }

        public class One {
            public One() {
            }

        }

    }

    private void initializeProviders() {
        // take account dependencies: top to bottom -> no dependencies to many dependencies
        try {
            configurations = configurationProviderClass.newInstance();
            localizations = localizationProviderClass.newInstance();
            models = modelProviderClass.newInstance();
            forms = formProviderClass.newInstance();
            styles = styleProviderClass.newInstance();
            tasks = taskProviderClass.newInstance();
            views = viewProviderClass.newInstance();
            controllers = controllerProviderClass.newInstance();
        } catch (InstantiationException | NullPointerException | IllegalAccessException e) {
            Log.error(e);
        }
    }


    public void executeCommand(String[] args) {

        Command commandToExecute = null;
        if (args.length == 0) {
            new TaskProviderImpl().help.getCommands()[0].value().getExecutor().execute(new String[0]);
            System.exit(0);
        }

        for (Map.Entry<String, Command> command : TaskProvider.retrieveAllCommands().entrySet()) {
            if (args[0].equals(command.getKey())) {
                commandToExecute = command.getValue();
            }
        }
        if (commandToExecute == null) {
            Log.error("No command %s found", args[0]);
            System.exit(0);
        }

        String[] declaredParameters = commandToExecute.getParameters();
        if (declaredParameters.length != args.length - 1) {
            Log.error("Wrong use of command %s, expected %s arguments", args[0], declaredParameters.length);
            System.exit(0);
        }

        String[] parameters = new String[declaredParameters.length];
        System.arraycopy(args, 1, parameters, 0, args.length - 1);
        commandToExecute.getExecutor().execute(parameters);
    }

}
