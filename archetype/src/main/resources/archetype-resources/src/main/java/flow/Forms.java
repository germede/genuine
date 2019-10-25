package ${package}.flow;

import org.fluentness.controller.web.form.Form;
import org.fluentness.controller.web.form.FormProducer;

public class Forms extends FormProducer {

    Form dummy = get("/dummy",
        title -> text()
    );

}
