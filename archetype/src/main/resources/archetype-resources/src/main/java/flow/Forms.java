package ${package}.flow;

import org.fluentness.flow.web.form.Form;
import org.fluentness.flow.web.form.FormProducer;

public class Forms extends FormProducer {

    Form dummy = get("/dummy",
        title -> text()
    );

}
