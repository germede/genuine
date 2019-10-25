package ${package}.flow;

import org.fluentness.controller.component.style.Style;
import org.fluentness.controller.component.style.StyleProducer;

public class Styles extends StyleProducer {

    Style dummy = css(
        select("*",
            color -> "red"
        )
    );

}
