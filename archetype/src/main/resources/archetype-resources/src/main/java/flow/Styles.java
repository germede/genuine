package ${package}.flow;

import org.fluentness.mobile.console.style.Style;
import org.fluentness.mobile.console.style.StyleProducer;

public class Styles extends StyleProducer {

    Style dummy = css(
        select("*",
            color -> "red"
        )
    );

}
