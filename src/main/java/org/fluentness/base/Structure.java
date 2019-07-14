package org.fluentness.base;

import org.fluentness.base.generics.Component;
import org.fluentness.flow.configuration.Configuration;
import org.fluentness.flow.controller.Controller;
import org.fluentness.flow.form.Form;
import org.fluentness.flow.locale.Locale;
import org.fluentness.flow.style.Style;
import org.fluentness.flow.task.Task;
import org.fluentness.flow.view.View;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public enum Structure implements Comparator<Class<? extends Component>> {

    call;

    public final String data = ".data";

    public final String configurations = ".flow.Configurations";
    public final String controllers = ".flow.Controllers";
    public final String forms = ".flow.Forms";
    public final String localizations = ".flow.Localizations";
    public final String styles = ".flow.Styles";
    public final String tasks = ".flow.Tasks";
    public final String views = ".flow.Views";

    public List<Class<? extends Component>> onionArchitecture = Arrays.asList(
        Configuration.class,
        Locale.class,
        Style.class,
        Form.class,
        View.class,
        Task.class,
        Controller.class
    );

    @Override
    public int compare(Class<? extends Component> componentType1, Class<? extends Component> componentType2) {
        return Integer.compare(onionArchitecture.indexOf(componentType1), onionArchitecture.indexOf(componentType2));
    }
}
