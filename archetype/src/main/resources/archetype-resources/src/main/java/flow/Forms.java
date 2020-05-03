package ${package}.flow;

import org.fluentness.controller.form.Form;
import org.fluentness.controller.form.FormProducer;

public class Forms extends FormProducer {

    Form dummy = get("/dummy",
        title -> text()
    );

}
