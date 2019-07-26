package ${package}.flow;

import org.fluentness.flow.producer.style.Style;
import org.fluentness.flow.producer.style.StyleProducer;

public class Styles extends StyleProducer {

    Style dummy = css(
        select("*",
            color -> "red"
        )
    );

}
