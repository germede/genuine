package com.sample;

import org.fluentness.style.Style;
import org.fluentness.style.StyleProvider;

public class Styles implements StyleProvider {

    Style base = css(
        select("form",
            font_size -> "12px",
            font_family -> "Helvetica",
            color -> "blue",

            select("input",
                font_size -> "12px",
                font_family -> "Helvetica"
            )
        ),
        select("p",
            font_size -> "14px",
            font_family -> "monospace",
            color -> "red"
        )
    );

}
