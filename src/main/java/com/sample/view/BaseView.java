package com.sample.view;

import org.fluentness.rendering.Renderable;
import org.fluentness.view.Placeholder;
import org.fluentness.view.View;

public class BaseView implements View.Html {

    @Placeholder
    private View placeholder;

    @Override
    public Renderable getRenderable() {
        return html(
                head(
                        title("A music archive made with love and Fluentness"),
                        meta(NAME -> "lang", CONTENT -> getLocale().getLanguage()),
                        meta(CHARSET -> "utf-8"),
                        includeCss("milligram.min.css"),
                        includeJs("script.min.js")
                ),
                body(
                        div(attrs(CLASS -> "container"),
                                h1(translate("welcome_message")),
                                placeholder.getRenderable()
                        )
                )
        );
    }
}
