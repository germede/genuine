package com.sample.controller;

import org.fluentness.controller.web.AbstractWeb;
import org.fluentness.controller.web.WebView;
import org.fluentness.controller.web.style.WebStyle;

import static com.sample.LibraryTranslation.*;
import static org.fluentness.controller.web.html.HtmlFactory.*;

public class Web extends AbstractWeb<WebController> {

    @Override
    public WebStyle getStyle() {
        return new WebStyle(
//
//            byTag(""),
//            byClass(""),
//            byId("")

        );
    }

    @Override
    public WebView getView(WebView toInclude) {
        return html(
            head(
                title(() -> "The book library made with Fluentness"),
                meta(_name("lang"), _content("en")),
                meta(_charset("UTF-8")),
//                link().rel("stylesheet").type("text/css").href("/resources/css/milligram.min.css"),
                link(_rel("stylesheet"), _type("text/css"), _href("https://cdnjs.cloudflare.com/ajax/libs/milligram/1.3.0/milligram.min.css")),
                link(_rel("stylesheet"), _type("text/css"), _href("/resources/css/styles.css")),
                script(_src("/resources/js/script.min.js"))
            ),
            body(
                div(_class("container"),
                    h2(_class("text_center"),
                        welcome_message::translate
                    ),
                    nav(
                        ul(_class("navigation_list"),
                            li(_class("navigation_item"),
                                action(controller::books, books::translate)
                            ),
                            li(_class("navigation_item"),
                                action(controller::authors, authors::translate)
                            )
                        )
                    ),
                    toInclude
                )
            )
        );
    }
}