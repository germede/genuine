package org.fluentness.common.constants;

import org.fluentness.common.generics.Component;
import org.fluentness.configuration.Configuration;
import org.fluentness.controller.Controller;
import org.fluentness.form.Form;
import org.fluentness.localization.Localization;
import org.fluentness.model.Model;
import org.fluentness.style.Style;
import org.fluentness.task.Task;
import org.fluentness.view.View;

import java.util.Arrays;
import java.util.List;

public interface OnionArchitecture {

    String CONFIGURATIONS = "Configurations";
    String CONTROLLERS = "Controllers";
    String FORMS = "Forms";
    String LOCALIZATIONS = "Localizations";
    String MODELS = "Models";
    String STYLES = "Styles";
    String TASKS = "Tasks";
    String VIEWS = "Views";

    List<Class<? extends Component>> ONION_ARCHITECTURE = Arrays.asList(
        Configuration.class,
        Localization.class,
        Model.class,
        Style.class,
        Form.class,
        View.class,
        Task.class,
        Controller.class
    );
}
