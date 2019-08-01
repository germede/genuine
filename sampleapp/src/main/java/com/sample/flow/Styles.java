package sample.flow;

import org.fluentness.flow.component.style.Style;
import org.fluentness.flow.provider.StyleProvider;

import static org.fluentness.flow.component.style.CssProperty.*;

public class Styles extends StyleProvider {

    private Style milligram = external("res/css/milligram.min.css");

    private Style custom = css(
        select(".form-inline",
            property(display, "flex"),
            property(flex_flow, "row wrap"),
            property(align_items, "center")
        ),
        select(".form-inline > input",
            property(width, "auto")
        ),
        select(".form-inline > input:not(:first-child)",
            property(margin_left, "5px")
        )
    );

    Style bundle = bundle(
        milligram,
        custom
    );
}
