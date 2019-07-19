package ${package}.flow;

import org.fluentness.flow.controller.Controller;
import org.fluentness.flow.controller.ControllerProvider;

public class Controllers extends ControllerProvider {

    Controller dummy = actions(
        index -> get("/", request -> response("Dummy"))
    );

}