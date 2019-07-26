package ${package}.flow;

import org.fluentness.flow.component.controller.Controller;
import org.fluentness.flow.component.controller.ControllerProducer;

public class Controllers extends ControllerProducer {

    Controller dummy = actions(
        index -> get("/", request -> response("Dummy"))
    );

}