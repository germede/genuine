package ${package}.flow;

import org.fluentness.flow.component.style.Style;
import org.fluentness.flow.component.style.StyleProducer;

public class Styles extends StyleProducer {

    Style dummy = css(
        select("*",
            color -> "red"
        )
    );

}
