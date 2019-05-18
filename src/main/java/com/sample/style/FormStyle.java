package com.sample.style;

import org.fluentness.style.Style;

public class FormStyle implements Style {

    @Override
    public Ruleset getRuleset() {
        return ruleset(
                select("form",
                        font_size -> "12px",
                        font_family -> "Helvetica",
                        color -> "blue",

                        select("input",
                                font_size -> "12px",
                                font_family -> "Helvetica"
                        )
                ),
                select("form",
                        font_size -> "12px",
                        font_family -> "Helvetica",
                        color -> "blue"
                )
        );
    }
}
