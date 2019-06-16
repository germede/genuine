package org.fluentness;

import org.fluentness.common.generics.Component;
import org.fluentness.common.generics.Consumer;
import org.fluentness.common.generics.Provider;
import org.fluentness.common.logging.Log;
import org.fluentness.configuration.ConfigurationProvider;
import org.fluentness.controller.ControllerProvider;
import org.fluentness.form.FormProvider;
import org.fluentness.localization.LocalizationProvider;
import org.fluentness.model.ModelProvider;
import org.fluentness.style.StyleProvider;
import org.fluentness.task.DefaultTasks;
import org.fluentness.task.Step;
import org.fluentness.task.Task;
import org.fluentness.task.TaskProvider;
import org.fluentness.view.ViewProvider;

import java.util.Arrays;
import java.util.Map;

import static org.fluentness.common.constants.AnsiColors.*;
import static org.fluentness.common.constants.OnionArchitecture.*;

public enum Fluentness {

    INSTANCE;

    private String appPackage;

    public ConfigurationProvider configurations;
    public ControllerProvider controllers;
    public FormProvider forms;
    public LocalizationProvider localizations;
    public ModelProvider models;
    public StyleProvider styles;
    public TaskProvider tasks;
    public ViewProvider views;

    public void initialize(String appPackage, String configurationToApply, String[] programArguments) {
        this.appPackage = appPackage;
        initOnionArchitecture(configurationToApply);
        executeCommand(programArguments);
    }

    private void initOnionArchitecture(String configurationToApply) {
        try {
            configurations = (ConfigurationProvider) Class.forName(appPackage + "." + CONFIGURATIONS).newInstance();
            Settings.INSTANCE.apply(configurations.get(configurationToApply));
            Log.INSTANCE.configure();
            checkOnionCompliance(configurations);

            localizations = (LocalizationProvider) Class.forName(appPackage + "." + LOCALIZATIONS).newInstance();
            checkOnionCompliance(localizations);

            models = (ModelProvider) Class.forName(appPackage + "." + MODELS).newInstance();
            checkOnionCompliance(models);

            styles = (StyleProvider) Class.forName(appPackage + "." + STYLES).newInstance();
            checkOnionCompliance(styles);

            forms = (FormProvider) Class.forName(appPackage + "." + FORMS).newInstance();
            checkOnionCompliance(forms);

            views = (ViewProvider) Class.forName(appPackage + "." + VIEWS).newInstance();
            checkOnionCompliance(views);

            tasks = (TaskProvider) Class.forName(appPackage + "." + TASKS).newInstance();
            tasks.putAll(new DefaultTasks().getAll());
            checkOnionCompliance(tasks);

            controllers = (ControllerProvider) Class.forName(appPackage + "." + CONTROLLERS).newInstance();
            checkOnionCompliance(controllers);

        } catch (InstantiationException | NullPointerException | IllegalAccessException | ClassNotFoundException e) {
            Log.INSTANCE.error(e);
        }
    }

    public void checkOnionCompliance(Provider producer) {
        Class<? extends Component> component = producer.getProducedComponentType();
        Class<? extends Consumer>[] consumers = Arrays.stream(producer.getClass().getInterfaces())
            .filter(Consumer.class::isAssignableFrom).toArray(Class[]::new);

        int componentPriority = ONION_ARCHITECTURE.indexOf(component);

        try {
            for (Class<? extends Consumer> consumer : consumers) {

                Class<? extends Component> consumerComponent =
                    (Class<? extends Component>) Class.forName(consumer.getCanonicalName().replace("Consumer", ""));

                int consumerComponentPriority = ONION_ARCHITECTURE.indexOf(consumerComponent);
                if (consumerComponentPriority > componentPriority) {
                    printOnionArchitecture();
                    Log.INSTANCE.fatal("%sProducer should not consume %s components due to the onion architecture",
                        component.getSimpleName(),
                        consumerComponent.getSimpleName()
                    );
                }
            }

        } catch (ClassNotFoundException e) {
            Log.INSTANCE.error(e);
            System.exit(1);
        }
    }

    public void printOnionArchitecture() {
        for (int i = 0; i < ONION_ARCHITECTURE.size(); i++) {
            String component = ONION_ARCHITECTURE.get(i).getSimpleName();
            if (i == 0) {
                System.out.println("\n" + ANSI_GREEN + "               ↑ ");
                System.out.println("LESS DEPENDANT | " + component + ANSI_RESET);
                continue;
            }
            if (i == ONION_ARCHITECTURE.size() - 1) {
                System.out.println(ANSI_BLUE + "MORE DEPENDANT | " + component);
                System.out.println("               ↓ " + ANSI_RESET);
                continue;
            }
            System.out.println("               | " + component);
        }
        System.out.println();
    }

    private void executeCommand(String[] args) {

        if (args.length == 0) {
            printHelp();
            System.exit(0);
        }

        String taskName = args[0].replaceAll(":", "_");
        Map.Entry<String, Task> taskToExecute = null;
        String[] declaredArguments = new String[0];
        for (Map.Entry<String, Task> task : tasks.getAll().entrySet()) {
            if (taskName.equals(task.getKey())) {
                taskToExecute = task;
                declaredArguments = task.getValue().getArguments();
                break;
            }
        }

        if (taskToExecute == null) {
            Log.INSTANCE.fatal("No task %s found", taskName);
        }
        assert taskToExecute != null;

        if (declaredArguments.length != args.length - 1) {
            Log.INSTANCE.fatal("Wrong use of task %s, expected %s arguments, got %s",
                taskToExecute.getKey(),
                declaredArguments.length,
                args.length - 1
            );
        }

        String[] arguments = new String[declaredArguments.length];
        System.arraycopy(args, 1, arguments, 0, args.length - 1);
        taskToExecute.getValue().execute(arguments);
    }

    public void printHelp() {
        System.out.println("\n" +
            " _______                                \n" +
            "(  /  //             _/_                \n" +
            " -/--// , , _  _ _   /  _ _   _  (   (  \n" +
            "_/  (/_(_/_(/_/ / /_(__/ / /_(/_/_)_/_)_\n");

        System.out.println(ANSI_GREEN + "Available tasks:\n" + ANSI_RESET);

        for (Map.Entry<String, Task> task : Fluentness.INSTANCE.tasks.getAll().entrySet()) {

            String[] declaredArguments = task.getValue().getArguments();

            String argumentsToPrint = declaredArguments.length > 0 ? Arrays.toString(declaredArguments) : "";
            System.out.println(String.format(ANSI_BLUE + "%-30s" + ANSI_RESET + "%s",
                task.getKey().replaceAll("_",":") + " " + argumentsToPrint,
                task.getValue().getDescription()
            ));

            if (task.getValue().getSteps().length > 0) {
                Step[] steps = task.getValue().getSteps();
                for (int i = 0; i < steps.length; i++) {
                    Step step = steps[i];
                    System.out.println(String.format(ANSI_PURPLE + "%-30s" + ANSI_RESET + "%s",
                        "    " + (i + 1) + ". " + step.getName(),
                        step.getDescription()
                    ));
                }
            }
        }
    }
}
