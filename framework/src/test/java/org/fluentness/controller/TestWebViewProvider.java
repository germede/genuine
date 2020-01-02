package org.fluentness.controller;

import org.fluentness.controller.web.View.html.Html;
import org.fluentness.controller.web.View.html.style.WebStyle;

import static org.fluentness.controller.web.View.html.HtmlFactory.*;

public class TestWebViewProvider extends WebViewProvider<TestWebController> {

    public TestWebViewProvider(TestWebController controller) {
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
    public Html getView(Html toInclude) {
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