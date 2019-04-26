package org.fluentness.view;

import org.fluentness.Configuration;

public class HtmlView extends MarkupView<HtmlView> {

    public HtmlView includeCss(String path) {
        return open(HtmlTag.link)
                .set("rel", "stylesheet")
                .set("type", "text/css")
                .set("href", Configuration.get(Configuration.APP_URL).concat("/res/").concat(path));
    }

    public HtmlView includeJs(String path) {
        return open(HtmlTag.script)
                .set("src", Configuration.get(Configuration.APP_URL).concat("/res/").concat(path))
                .close(HtmlTag.script);
    }

    public HtmlView title(String title) {
        return open(HtmlTag.title).append(title).close(HtmlTag.title);
    }

    public HtmlView meta() {
        return open(HtmlTag.meta);
    }

    @Override
    protected HtmlView self() {
        return this;
    }
}
