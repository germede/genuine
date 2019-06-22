package org.fluentness.common.constants;

import org.fluentness.common.generics.Component;
import org.fluentness.flow.configuration.Configuration;
import org.fluentness.flow.controller.Controller;
import org.fluentness.flow.form.Form;
import org.fluentness.flow.localization.Localization;
import org.fluentness.data.Model;
import org.fluentness.flow.style.Style;
import org.fluentness.flow.task.Task;
import org.fluentness.flow.view.View;

import java.util.Arrays;
import java.util.List;

public interface OnionArchitecture {

    String CONFIGURATIONS = ".flow.Configurations";
    String CONTROLLERS = ".flow.Controllers";
    String FORMS = ".flow.Forms";
    String LOCALIZATIONS = ".flow.Localizations";
    String MODELS = ".flow.Models";
    String STYLES = ".flow.Styles";
    String TASKS = ".flow.Tasks";
    String VIEWS = ".flow.Views";

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
