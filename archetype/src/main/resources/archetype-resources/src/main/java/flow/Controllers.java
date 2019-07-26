package ${package}.flow;

import org.fluentness.flow.producer.controller.Controller;
import org.fluentness.flow.producer.controller.ControllerProducer;

public class Controllers extends ControllerProducer {

    Controller dummy = actions(
        index -> get("/", request -> response("Dummy"))
    );

}