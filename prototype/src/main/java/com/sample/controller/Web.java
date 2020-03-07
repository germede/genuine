package com.sample.controller;

import org.fluentness.controller.web.View;
import org.fluentness.controller.web.template.WebTemplate;
import org.fluentness.controller.web.template.html.style.WebStyle;

import static com.sample.service.LibraryTranslator.*;
import static org.fluentness.controller.web.template.html.HtmlAttribute.*;
import static org.fluentness.controller.web.template.html.HtmlFactory.*;

public class Web implements View {

    @Override
    public WebStyle getStyle() {
        return null;
    }

    @Override
    public WebTemplate getTemplate(CharSequence toInclude) {
        return html(
            head(
                title("The book library made with Fluentness"),
                meta(NAME + "lang", CONTENT + "en"),
                meta(CHARSET + "UTF-8"),
                link(REL + "stylesheet", TYPE + "text/css", HREF + "https://cdnjs.cloudflare.com/ajax/libs/milligram/1.3.0/milligram.min.css"),
                link(REL + "stylesheet", TYPE + "text/css", HREF + "/resources/css/styles.css"),
                script(SRC + "/resources/js/script.min.js")
            ),
            body(
                div(CLASS + "container",
                    h2(CLASS + "text_center", welcome_message),
                    nav(
                        ul(CLASS + "navigation_list",
                            li(CLASS + "navigation_item", ID + "books", books),
                            li(CLASS + "navigation_item", ID + "authors", authors)
                        ),
                        toInclude
                    )
                )
            )
        );
    }

}