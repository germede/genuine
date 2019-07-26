package ${package}.flow;

import org.fluentness.flow.component.form.Form;
import org.fluentness.flow.component.form.FormProducer;

public class Forms extends FormProducer {

    Form dummy = get("/dummy",
        title -> text()
    );

}
