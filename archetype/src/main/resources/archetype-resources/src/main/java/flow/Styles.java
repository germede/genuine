package ${package}.flow;

import org.fluentness.flow.style.Style;
import org.fluentness.flow.style.StyleProvider;

public class Styles extends StyleProvider {

    Style dummy = css(
        select("*",
            color -> "red"
        )
    );

}
