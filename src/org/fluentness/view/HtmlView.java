package org.fluentness.view;

import org.fluentness.routing.Server;

public class HtmlView extends MarkupView<HtmlView> {

    public HtmlView includeCss(String path) {
        return open(HtmlTag.link)
                .set("rel", "stylesheet")
                .set("type", "text/css")
                .set("href", Server.getBaseAddress().concat("/res/").concat(path));
    }

    public HtmlView includeJs(String path) {
        return open(HtmlTag.script)
                .set("src", Server.getBaseAddress().concat("/res/").concat(path))
                .close(HtmlTag.script);
    }

    @Override
    protected HtmlView self() {
        return this;
    }
}
