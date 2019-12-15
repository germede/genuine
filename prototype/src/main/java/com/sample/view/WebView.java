package com.sample.view;

import com.sample.localization.StringLocalization;
import org.fluentness.view.View;

import static org.fluentness.view.web.HtmlAttribute.*;
import static org.fluentness.view.web.HtmlFactory.*;

public class WebView implements View<WebController> {

    private StringLocalization l10n;

    public WebView(StringLocalization l10n) {
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