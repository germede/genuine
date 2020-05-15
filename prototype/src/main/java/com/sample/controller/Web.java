package com.sample.controller;

import org.fluentness.controller.AbstractWeb;
import org.fluentness.controller.WebView;

import static com.sample.service.StringTranslator.*;
import static org.fluentness.controller.html.HtmlAttribute.*;

public class Web extends AbstractWeb {

    @Override
    public WebView render() {
        return html(
            head(
                title("The book library made with Fluentness"),
                meta(NAME + "lang", CONTENT + "en"),
                meta(CHARSET + "UTF-8"),
                meta(NAME + "viewport", CONTENT + "width=device-width, initial-scale=1"),
                link(REL + "stylesheet", TYPE + "text/css", HREF + "https://cdn.jsdelivr.net/npm/picnic"),
                link(REL + "stylesheet", TYPE + "text/css", HREF + "https://icono-49d6.kxcdn.com/icono.min.css"),
                link(REL + "stylesheet", TYPE + "text/css", HREF + "/resources/css/styles.css"),

                script(SRC + "/resources/js/script.min.js", "-")
            ),
            body(
                nav(
                    a(ID + "index", CLASS + "brand", "WorkStation"),
                    input(ID + "burger", TYPE + "checkbox", CLASS + "show"),
                    label(FOR + "burger", CLASS + "burger pseudo button", _menu),
                    div(CLASS + "menu",
                        action("notes", CLASS + "pseudo button", _notes),
                        action("events", CLASS + "pseudo button", _events),
                        action("bookmarks", CLASS + "pseudo button", "Bookmarks"),
                        action("users", CLASS + "pseudo button", _users)
                    )
                ),
                div(CLASS + "flex wrapper",
                    ACTION_RESULT
                )
            )
        );
    }

}