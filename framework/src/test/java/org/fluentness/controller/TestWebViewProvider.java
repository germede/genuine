package org.fluentness.controller;

import org.fluentness.controller.web.WebViewProvider;
import org.fluentness.view.web.HtmlView;
import org.fluentness.style.web.WebStyle;

import static org.fluentness.view.web.HtmlFactory.*;

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
    public HtmlView getView(HtmlView toInclude) {
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