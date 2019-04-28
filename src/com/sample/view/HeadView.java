package com.sample.view;

import org.fluentness.view.Cacheable;
import org.fluentness.view.View;

import java.io.Serializable;

import static org.fluentness.templating.HtmlAttribute.*;
import static org.fluentness.templating.HtmlElement.*;
import static org.fluentness.templating.HtmlElement.title;

@Cacheable
public class HeadView implements View {

    @Override
    public Serializable render() {
        return head(
                title("the best site"),
                meta(name("lang"),content("es")),
                meta(charset("utf-8"))
        );
    }
}
