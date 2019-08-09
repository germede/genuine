package ${package}.flow;

import org.fluentness.flow.view.form.Form;
import org.fluentness.flow.view.form.FormProducer;

public class Forms extends FormProducer {

    Form dummy = get("/dummy",
        title -> text()
    );

}
