package com.sample.style;

import org.fluentness.style.Style;

public class FormStyle implements Style {

    @Override
    public Selectors getSelectors() {

        return selectors(
                selector("form",
                        font_size -> "12px",
                        font_family -> "Helvetica",
                        color -> "blue",

                        selector("input",
                                font_size -> "12px",
                                font_family -> "Helvetica"
                        )
                ),
                selector("form",
                        font_size -> "12px",
                        font_family -> "Helvetica",
                        color -> "blue"
                )
        );
    }
}
