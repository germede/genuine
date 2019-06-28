package org.fluentness.flow;

import org.fluentness.base.Settings;
import org.fluentness.base.Structure;
import org.fluentness.base.exceptions.FluentnessInitializationException;
import org.fluentness.base.generics.Component;
import org.fluentness.base.generics.Consumer;
import org.fluentness.base.generics.Provider;
import org.fluentness.base.logging.Log;
import org.fluentness.flow.configuration.ConfigurationProvider;
import org.fluentness.flow.controller.ControllerProvider;
import org.fluentness.flow.form.FormProvider;
import org.fluentness.flow.localization.LocalizationProvider;
import org.fluentness.flow.style.StyleProvider;
import org.fluentness.flow.task.DefaultTasks;
import org.fluentness.flow.task.TaskProvider;
import org.fluentness.flow.view.ViewProvider;

import java.util.Arrays;

public enum Flow {
    call;

    public ConfigurationProvider configurations;
    public ControllerProvider controllers;
    public FormProvider forms;
    public LocalizationProvider localizations;
    public StyleProvider styles;
    public TaskProvider tasks;
    public ViewProvider views;

    public void initialize(String appPackage, String configurationToApply) throws FluentnessInitializationException {

        try {
            configurations = (ConfigurationProvider) Class.forName(appPackage + Structure.call.configurations).newInstance();
            Settings.call.apply(configurations.get(configurationToApply));
            Log.call.configure();
            checkOnionCompliance(configurations);

            localizations = (LocalizationProvider) Class.forName(appPackage + Structure.call.localizations).newInstance();
            checkOnionCompliance(localizations);

            styles = (StyleProvider) Class.forName(appPackage + Structure.call.styles).newInstance();
            checkOnionCompliance(styles);

            forms = (FormProvider) Class.forName(appPackage + Structure.call.forms).newInstance();
            checkOnionCompliance(forms);

            views = (ViewProvider) Class.forName(appPackage + Structure.call.views).newInstance();
            checkOnionCompliance(views);

            tasks = (TaskProvider) Class.forName(appPackage + Structure.call.tasks).newInstance();
            tasks.addAll(new DefaultTasks().getAll());
            checkOnionCompliance(tasks);

            controllers = (ControllerProvider) Class.forName(appPackage + Structure.call.controllers).newInstance();
            checkOnionCompliance(controllers);

        } catch (InstantiationException | NullPointerException | IllegalAccessException | ClassNotFoundException e) {
            throw new FluentnessInitializationException("Exception while initializing onion architecture", e);
        }
    }

    public void checkOnionCompliance(Provider provider) throws FluentnessInitializationException {

        Class producedComponentType = provider.getProducedComponentType();

        try {
            for (Class<? extends Consumer> consumer :
                Arrays.stream(provider.getClass().getInterfaces())
                    .filter(Consumer.class::isAssignableFrom).toArray(Class[]::new)
            ) {
                Class<? extends Component> consumerComponentType =
                    (Class<? extends Component>) Class.forName(consumer.getCanonicalName().replace("Consumer", ""));

                if (Structure.call.compare(producedComponentType, consumerComponentType) < 0) {
                    throw new FluentnessInitializationException(
                        "%s should not consume %s components due to the onion architecture",
                        provider.getClass().getSimpleName(),
                        consumerComponentType.getSimpleName()
                    );
                }
            }

        } catch (ClassNotFoundException e) {
            throw new FluentnessInitializationException(e);
        }
    }

}
