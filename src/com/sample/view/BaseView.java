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
                        title("the best site"),
                        meta(NAME -> "lang", CONTENT -> "es"),
                        meta(CHARSET -> "utf-8")
                ),
                body(
                        placeholder.getRenderable()
                )
        );
    }
}
