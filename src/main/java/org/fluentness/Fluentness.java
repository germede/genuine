package org.fluentness;

import org.fluentness.base.logging.Log;
import org.fluentness.base.onion.Component;
import org.fluentness.base.onion.Consumer;
import org.fluentness.base.onion.Producer;
import org.fluentness.base.settings.Settings;
import org.fluentness.controller.Controller;
import org.fluentness.controller.ControllerProducer;
import org.fluentness.form.Form;
import org.fluentness.form.FormProducer;
import org.fluentness.localization.Localization;
import org.fluentness.localization.LocalizationProducer;
import org.fluentness.model.Model;
import org.fluentness.model.ModelProducer;
import org.fluentness.style.Style;
import org.fluentness.style.StyleProducer;
import org.fluentness.task.FnTaskProvider;
import org.fluentness.task.Task;
import org.fluentness.task.TaskProducer;
import org.fluentness.view.View;
import org.fluentness.view.ViewProducer;

import java.util.*;

public enum Fluentness {

    INSTANCE;

    public String appPackage;

    public ControllerProducer controllers;
    public FormProducer forms;
    public LocalizationProducer localizations;
    public ModelProducer models;
    public StyleProducer styles;
    public TaskProducer tasks;
    public ViewProducer views;

    public List<Class<? extends Component>> onionArchitecture = new ArrayList<>();

    public void initialize(String appPackage, Settings settingsToApply, String[] programArguments) {
        settingsToApply.apply();
        Log.INSTANCE.configure();
        try {
            Fluentness.INSTANCE.appPackage = appPackage;
            initOnionArchitecture();
            executeCommand(programArguments);
        } catch (Exception e) {
            Log.INSTANCE.error(e);
        }
    }

    private void initOnionArchitecture() {
        try {
            // onion hierarchy and naming conventions are hereby defined

            onionArchitecture.add(Localization.class);
            onionArchitecture.add(Model.class);
            onionArchitecture.add(Style.class);
            onionArchitecture.add(Form.class);
            onionArchitecture.add(View.class);
            onionArchitecture.add(Task.class);
            onionArchitecture.add(Controller.class);

            localizations = (LocalizationProducer) Class.forName(appPackage + ".Localizations").newInstance();
            models = (ModelProducer) Class.forName(appPackage + ".Models").newInstance();
            styles = (StyleProducer) Class.forName(appPackage + ".Styles").newInstance();
            forms = (FormProducer) Class.forName(appPackage + ".Forms").newInstance();
            views = (ViewProducer) Class.forName(appPackage + ".Views").newInstance();
            tasks = (TaskProducer) Class.forName(appPackage + ".Tasks").newInstance();
            controllers = (ControllerProducer) Class.forName(appPackage + ".Controllers").newInstance();

            checkOnionCompliance(localizations);
            checkOnionCompliance(models);
            checkOnionCompliance(styles);
            checkOnionCompliance(forms);
            checkOnionCompliance(views);
            checkOnionCompliance(tasks);
            checkOnionCompliance(controllers);

            Map<String, Task> all = new FnTaskProvider().getAll();
            tasks.putAll(all);

        } catch (InstantiationException | NullPointerException | IllegalAccessException | ClassNotFoundException e) {
            Log.INSTANCE.error(e);
        }
    }

    public void checkOnionCompliance(Producer producer) {
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

        Map.Entry<String, Task> taskToExecute = null;
        String[] declaredArguments = new String[0];
        for (Map.Entry<String, Task> task : tasks.getAll().entrySet()) {
            if (args[0].equals(task.getKey())) {
                taskToExecute = task;
                declaredArguments = task.getValue().getArguments();
                break;
            }
        }

        if (taskToExecute == null) {
            Log.INSTANCE.fatal("No task %s found", args[0]);
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
