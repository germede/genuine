package ${package}.flow;

import org.fluentness.flow.view.View;
import org.fluentness.flow.view.ViewProvider;

public class Views extends ViewProvider {

    View dummy = html(
        head(
            title("Dummy")
        ),
        body(
            "dummy"
        )
    );

}
