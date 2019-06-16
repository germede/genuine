package com.sample;

import org.fluentness.style.Style;
import org.fluentness.style.StyleProvider;

public class Styles extends StyleProvider {

    Style milligram = external("res/css/milligram.min.css");

    Style custom = css(
        select(".form-inline",
            display -> "flex",
            flex_flow -> "row wrap",
            align_items -> "center"
        ),

        select(".form-inline > input",
            width -> "auto"
        ),

        select(".form-inline > input:not(:first-child)",
            margin_left -> "5px"
        )
    );

    Style bundle = bundle(
        this.milligram,
        this.custom
    );
}
