package ${package}.flow;

import org.fluentness.controller.view.View;
import org.fluentness.controller.view.ViewProducer;

public class Views extends ViewProducer {

    View dummy = html(
        head(
            title("Dummy")
        ),
        body(
            "dummy"
        )
    );

}
