package ${package}.flow;

import org.fluentness.flow.form.Form;
import org.fluentness.flow.form.FormProvider;

public class Forms extends FormProvider {

    Form dummy = get("/dummy",
        title -> text()
    );

}
