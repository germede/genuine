package com.sample.flow;

import org.fluentness.flow.component.style.Style;
import org.fluentness.flow.provider.Provider;

import static org.fluentness.base.common.constant.CssProperty.*;
import static org.fluentness.flow.component.style.StyleFactory.*;

public class StyleProvider implements Provider<Style> {

    final Style bundle = merge(
            external("res/css/milligram.min.css"),
            css(
                    select(".form-inline",
                            display + "flex",
                            flex_flow + "row wrap",
                            align_items + "center"
                    ),
                    select(".form-inline > input",
                            width + "auto"
                    ),
                    select(".form-inline > input:not(:first-child)",
                            margin_left + "5px"
                    )
            )
    );
}
