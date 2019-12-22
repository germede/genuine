package com.sample.controller;

import com.sample.LibraryLocalization;
import org.fluentness.controller.View;

import static org.fluentness.controller.web.view.HtmlAttribute.*;
import static org.fluentness.controller.web.view.HtmlFactory.*;

public class Web implements View<WebController> {

    private LibraryLocalization l10n;

    private WebController controller;

    public Web(LibraryLocalization l10n) {
        this.l10n = l10n;
    }

    @Override
    public Object render(Object... toInclude) {

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
                    h2(CLASS + "text_center",
                        l10n.welcome_message
                    ),
                    nav(
                        ul(CLASS + "navigation_list",
                            li(CLASS + "navigation_item",
                                action(controller::books, l10n.books)
                            ),
                            li(CLASS + "navigation_item",
                                action(controller::authors, l10n.authors)
                            )
                        )
                    ),
                    toInclude
                )
            )
        );
    }
}