package ${package}.flow;

import org.fluentness.controller.Controller;
import org.fluentness.controller.ControllerProducer;

public class Controllers extends ControllerProducer {

    Controller dummy = actions(
        index -> get("/", request -> response("Dummy"))
    );

}