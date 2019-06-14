package org.fluentness.base.components;

import org.fluentness.Fluentness;
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
import org.fluentness.task.Task;
import org.fluentness.task.TaskProvider;
import org.fluentness.view.View;
import org.fluentness.view.ViewProvider;

import static org.fluentness.base.constants.Settings.*;

public interface Components {


    static FormProvider forms() {
        return (FormProvider) Fluentness.getOrDefault(PROVIDER_FORMS, new FormProvider() {
        });
    }

    static ControllerProvider controllers() {
        return (ControllerProvider) Fluentness.getOrDefault(PROVIDER_CONTROLLERS, new ControllerProvider() {
        });
    }

    static LocalizationProvider localizations() {
        return (LocalizationProvider) Fluentness.getOrDefault(PROVIDER_LOCALIZATIONS, new LocalizationProvider() {
        });
    }

    static ModelProvider models() {
        return (ModelProvider) Fluentness.getOrDefault(PROVIDER_MODELS, new ModelProvider() {
        });
    }

    static StyleProvider styles() {
        return (StyleProvider) Fluentness.getOrDefault(PROVIDER_STYLES, new StyleProvider() {
        });
    }

    static TaskProvider tasks() {
        return (TaskProvider) Fluentness.getOrDefault(PROVIDER_TASKS, new TaskProvider() {
        });
    }

    static ViewProvider views() {
        return (ViewProvider) Fluentness.getOrDefault(PROVIDER_VIEWS, new ViewProvider() {
        });
    }

    default Form form(String name) {
        return forms().get(name);
    }

    default Controller controller(String name) {
        return controllers().get(name);
    }

    default Localization localization(String name) {
        return localizations().get(name);
    }

    default Model model(String name) {
        return models().get(name);
    }

    default Style style(String name) {
        return styles().get(name);
    }

    default Task task(String name) {
        return tasks().get(name);
    }

    default View view(String name) {
        return views().get(name);
    }
}
