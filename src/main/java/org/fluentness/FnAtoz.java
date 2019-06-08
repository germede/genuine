package org.fluentness;

import org.fluentness.controller.ControllerProvider;
import org.fluentness.form.FormProvider;
import org.fluentness.localization.LocalizationProvider;
import org.fluentness.model.ModelProvider;
import org.fluentness.style.StyleProvider;
import org.fluentness.task.TaskProvider;
import org.fluentness.view.ViewProvider;

import static org.fluentness.common.constants.Settings.*;

public final class FnAtoz {


    public static FormProvider getFormProvider() {
        return (FormProvider) FnConf.getOrDefault(PROVIDER_FORMS, new FormProvider() {
        });
    }

    public static ControllerProvider getControllerProvider() {
        return (ControllerProvider) FnConf.getObject(PROVIDER_CONTROLLERS);
    }

    public static LocalizationProvider getLocalizationProvider() {
        return (LocalizationProvider) FnConf.getOrDefault(PROVIDER_LOCALIZATIONS, new LocalizationProvider() {
        });
    }

    public static ModelProvider getModelProvider() {
        return (ModelProvider) FnConf.getOrDefault(PROVIDER_MODELS, new ModelProvider() {
        });
    }

    public static StyleProvider getStyleProvider() {
        return (StyleProvider) FnConf.getOrDefault(PROVIDER_STYLES, new StyleProvider() {
        });
    }

    public static TaskProvider getTaskProvider() {
        return (TaskProvider) FnConf.getOrDefault(PROVIDER_TASKS, new TaskProvider() {
        });
    }

    public static ViewProvider getViewProvider() {
        return (ViewProvider) FnConf.getOrDefault(PROVIDER_VIEWS, new ViewProvider() {
        });
    }
}
