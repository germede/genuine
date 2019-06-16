package org.fluentness;

import org.fluentness.common.components.Component;
import org.fluentness.common.components.Consumer;
import org.fluentness.common.components.Provider;
import org.fluentness.common.logging.Log;
import org.fluentness.configuration.ConfigurationProvider;
import org.fluentness.controller.Controller;
import org.fluentness.controller.ControllerProvider;
import org.fluentness.form.Form;
import org.fluentness.form.FormProvider;
import org.fluentness.localization.Localization;
import org.fluentness.localization.LocalizationProvider;
import org.fluentness.model.Model;
import org.fluentness.model.ModelProvider;
import org.fluentness.style.Style;
import org.fluentness.style.StyleProvider;
import org.fluentness.task.FnTaskProvider;
import org.fluentness.task.Task;
import org.fluentness.task.TaskProvider;
import org.fluentness.view.View;
import org.fluentness.view.ViewProvider;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

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

    public static final List<Class<? extends Component>> onionArchitecture = new ArrayList<>();

    static {
        onionArchitecture.add(Localization.class);
        onionArchitecture.add(Model.class);
        onionArchitecture.add(Style.class);
        onionArchitecture.add(Form.class);
        onionArchitecture.add(View.class);
        onionArchitecture.add(Task.class);
        onionArchitecture.add(Controller.class);
    }

    public void initialize(String appPackage, String settingsToApply, String[] programArguments) {
        this.appPackage = appPackage;
        initOnionArchitecture(settingsToApply);
        executeCommand(programArguments);
    }

    private void initOnionArchitecture(String settingsToApply) {
        try {
            // onion hierarchy and naming conventions are hereby granted
            configurations = (ConfigurationProvider) Class.forName(appPackage + ".Configurations").newInstance();
            configurations.get(settingsToApply).apply();
            Log.INSTANCE.configure();

            localizations = (LocalizationProvider) Class.forName(appPackage + ".Localizations").newInstance();
            models = (ModelProvider) Class.forName(appPackage + ".Models").newInstance();
            styles = (StyleProvider) Class.forName(appPackage + ".Styles").newInstance();
            forms = (FormProvider) Class.forName(appPackage + ".Forms").newInstance();
            views = (ViewProvider) Class.forName(appPackage + ".Views").newInstance();
            tasks = (TaskProvider) Class.forName(appPackage + ".Tasks").newInstance();
            controllers = (ControllerProvider) Class.forName(appPackage + ".Controllers").newInstance();

            checkOnionCompliance(localizations);
            checkOnionCompliance(models);
            checkOnionCompliance(styles);
            checkOnionCompliance(forms);
            checkOnionCompliance(views);
            checkOnionCompliance(tasks);
            checkOnionCompliance(controllers);

            tasks.putAll(new FnTaskProvider().getAll());

        } catch (InstantiationException | NullPointerException | IllegalAccessException | ClassNotFoundException e) {
            Log.INSTANCE.error(e);
        }
    }

    public void checkOnionCompliance(Provider producer) {
        Class<? extends Component> component = producer.getProducedComponentType();
        Class<? extends Consumer>[] consumers = Arrays.stream(producer.getClass().getInterfaces())
            .filter(Consumer.class::isAssignableFrom).toArray(Class[]::new);

        int componentPriority = onionArchitecture.indexOf(component);

        try {
            for (Class<? extends Consumer> consumer : consumers) {

                Class<? extends Component> consumerComponent =
                    (Class<? extends Component>) Class.forName(consumer.getCanonicalName().replace("Consumer", ""));

                int consumerComponentPriority = onionArchitecture.indexOf(consumerComponent);
                if (consumerComponentPriority > componentPriority) {

                    Log.INSTANCE.fatal("%sProducer should not consume %s due to the onion architecture",
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

    private void executeCommand(String[] args) {

        if (args.length == 0) {
            tasks.get("help").execute(new String[0]);
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
}
