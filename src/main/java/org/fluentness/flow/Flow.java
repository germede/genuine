package org.fluentness.flow;

import org.fluentness.base.exceptions.FluentnessInitializationException;
import org.fluentness.base.generics.Component;
import org.fluentness.base.generics.Consumer;
import org.fluentness.base.generics.Provider;
import org.fluentness.flow.controller.Controller;
import org.fluentness.flow.controller.ControllerProvider;
import org.fluentness.flow.form.Form;
import org.fluentness.flow.form.FormProvider;
import org.fluentness.flow.locale.Locale;
import org.fluentness.flow.locale.LocaleProvider;
import org.fluentness.flow.repository.Repository;
import org.fluentness.flow.repository.RepositoryProvider;
import org.fluentness.flow.style.Style;
import org.fluentness.flow.style.StyleProvider;
import org.fluentness.flow.task.DefaultTasks;
import org.fluentness.flow.task.Task;
import org.fluentness.flow.task.TaskProvider;
import org.fluentness.flow.view.View;
import org.fluentness.flow.view.ViewProvider;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public enum Flow implements Comparator<Class<? extends Component>> {
    call;

    public RepositoryProvider repositories;
    public LocaleProvider locales;
    public StyleProvider styles;
    public FormProvider forms;
    public ViewProvider views;
    public TaskProvider tasks;
    public ControllerProvider controllers;

    public List<Class<? extends Component>> onionArchitecture = Arrays.asList(
        Repository.class,
        Locale.class,
        Style.class,
        Form.class,
        View.class,
        Task.class,
        Controller.class
    );

    public void initialize(String appPackage) throws FluentnessInitializationException {

        try {

            repositories = (RepositoryProvider) Class.forName(appPackage + ".flow.Repositories").newInstance();
            checkOnionCompliance(repositories);

            locales = (LocaleProvider) Class.forName(appPackage + ".flow.Locales").newInstance();
            checkOnionCompliance(locales);

            styles = (StyleProvider) Class.forName(appPackage + ".flow.Styles").newInstance();
            checkOnionCompliance(styles);

            forms = (FormProvider) Class.forName(appPackage + ".flow.Forms").newInstance();
            checkOnionCompliance(forms);

            views = (ViewProvider) Class.forName(appPackage + ".flow.Views").newInstance();
            checkOnionCompliance(views);

            tasks = (TaskProvider) Class.forName(appPackage + ".flow.Tasks").newInstance();
            tasks.addAll(new DefaultTasks().getAll());
            checkOnionCompliance(tasks);

            controllers = (ControllerProvider) Class.forName(appPackage + ".flow.Controllers").newInstance();
            checkOnionCompliance(controllers);

        } catch (InstantiationException | NullPointerException | IllegalAccessException | ClassNotFoundException e) {
            throw new FluentnessInitializationException("Exception while initializing onion architecture", e);
        }
    }

    public void checkOnionCompliance(Provider provider) throws FluentnessInitializationException {

        Class producedComponentType = provider.getProducedComponentType();

        try {
            Class[] consumerClasses = Arrays.stream(provider.getClass().getInterfaces())
                .filter(Consumer.class::isAssignableFrom).toArray(Class[]::new);

            for (Class<? extends Consumer> consumer : consumerClasses) {
                Class<? extends Component> consumerComponentType =
                    (Class<? extends Component>) Class.forName(consumer.getCanonicalName().replace("Consumer", ""));

                if (compare(producedComponentType, consumerComponentType) < 0) {
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

    @Override
    public int compare(Class<? extends Component> componentType1, Class<? extends Component> componentType2) {
        return Integer.compare(onionArchitecture.indexOf(componentType1), onionArchitecture.indexOf(componentType2));
    }
}
