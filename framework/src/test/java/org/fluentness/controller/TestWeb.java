package org.fluentness.controller;

import org.fluentness.controller.web.AbstractWeb;
import org.fluentness.controller.web.WebView;
import org.fluentness.controller.web.style.WebStyle;

import static org.fluentness.controller.web.view.HtmlFactory.*;

public class TestWeb extends AbstractWeb<TestWebController> {

    public TestWeb(TestWebController controller) {
        super(controller);
    }

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
                title(() -> "Dummy")
            ),
            body(
                toInclude
            )
        );
    }
}