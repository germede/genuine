package org.fluentness.controller;

import org.fluentness.controller.web.WebViewProvider;
import org.fluentness.controller.web.view.html.Html;
import org.fluentness.controller.web.view.html.style.WebStyle;

import static org.fluentness.controller.web.view.html.HtmlFactory.*;

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