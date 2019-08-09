package ${package}.flow;

import org.fluentness.flow.view.View;
import org.fluentness.flow.view.ViewProducer;

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
