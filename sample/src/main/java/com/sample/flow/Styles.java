package com.sample.flow;

import org.fluentness.flow.producer.style.Style;
import org.fluentness.flow.producer.style.StyleProducer;

public class Styles extends StyleProducer {

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
        milligram,
        custom
    );
}
