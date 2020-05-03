package ${package}.flow;

import org.fluentness.mobile.view.View;
import org.fluentness.mobile.view.ViewProducer;

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
