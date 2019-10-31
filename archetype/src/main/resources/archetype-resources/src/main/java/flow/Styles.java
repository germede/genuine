package ${package}.flow;

import org.fluentness.controller.console.style.Style;
import org.fluentness.controller.console.style.StyleProducer;

public class Styles extends StyleProducer {

    Style dummy = css(
        select("*",
            color -> "red"
        )
    );

}
