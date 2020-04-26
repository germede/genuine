package com.sample.controller;

import com.sample.WorkStation;
import org.fluentness.controller.web.AbstractWebView;
import org.fluentness.controller.web.template.WebTemplate;
import org.fluentness.controller.web.template.html.style.WebStyle;

import static com.sample.service.Translator.*;
import static org.fluentness.controller.web.template.html.HtmlAttribute.*;
import static org.fluentness.controller.web.template.html.HtmlFactory.*;

public class WebView extends AbstractWebView<WebController> {

    @Override
    public WebStyle getStyle() {
        return null;
    }

    @Override
    public WebTemplate getTemplate(CharSequence actionResult) {
        return html(
            head(
                title("The book library made with Fluentness"),
                meta(NAME + "lang", CONTENT + "en"),
                meta(CHARSET + "UTF-8"),
                link(REL + "stylesheet", TYPE + "text/css", HREF + "https://cdn.jsdelivr.net/npm/picnic"),
                link(REL + "stylesheet", TYPE + "text/css", HREF + "/resources/css/styles.css"),
                script(SRC + "/resources/js/script.min.js")
            ),
            body(
                div(CLASS + "container",
                    h2(CLASS + "text_center", welcome_message),
                    nav(
                        a(ID + "index", CLASS + "brand", WorkStation.class.getSimpleName()),

                        input(ID + "burger", TYPE + "checkbox", CLASS + "show"),
                        label(FOR + "burger", CLASS + "burger pseudo button", menu),

                        div(CLASS + "menu",
                            a(ID + "notes", CLASS + "pseudo button $current", notes),
                            a(CLASS + "pseudo button $current", authors)
                        )
                    ),
                    actionResult
                )
            )
        );
    }
}