package com.sample.controller;

import org.fluentness.controller.web.View;
import org.fluentness.controller.web.template.WebTemplate;

import static com.sample.repository.Translation.*;
import static org.fluentness.controller.web.template.html.HtmlFactory.*;

public class Web implements View {

    @Override
    public WebTemplate getTemplate(WebTemplate toInclude) {
        return html(
            head(
                title("The book library made with Fluentness"),
                meta(_name("lang"), _content("en")),
                meta(_charset("UTF-8")),
                link(_rel("stylesheet"), _type("text/css"), _href("https://cdnjs.cloudflare.com/ajax/libs/milligram/1.3.0/milligram.min.css")),
                link(_rel("stylesheet"), _type("text/css"), _href("/resources/css/styles.css")),
                script(_src("/resources/js/script.min.js"))
            ),
            body(
                div(_class("container"),
                    h2(_class("text_center"), welcome_message),
                    nav(
                        ul(_class("navigation_list"),
                            li(_class("navigation_item"), _id("books"), books),
                            li(_class("navigation_item"), _id("authors"), authors)
                        ),
                        toInclude
                    )
                )
            )
        );
    }


}