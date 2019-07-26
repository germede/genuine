package ${package}.flow;

import org.fluentness.flow.producer.form.Form;
import org.fluentness.flow.producer.form.FormProducer;

public class Forms extends FormProducer {

    Form dummy = get("/dummy",
        title -> text()
    );

}
