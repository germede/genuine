package org.fluentness.view;

import org.fluentness.Configuration;

public class HtmlView extends MarkupView<HtmlView> {

    public HtmlView includeCss(String path) {
        return open(Tag.link)
                .set("rel", "stylesheet")
                .set("type", "text/css")
                .set("href", Configuration.get(Configuration.APP_URL).concat("/res/").concat(path));
    }

    public HtmlView includeJs(String path) {
        return open(Tag.script)
                .set("src", Configuration.get(Configuration.APP_URL).concat("/res/").concat(path))
                .close(Tag.script);
    }

    public HtmlView title(String title) {
        return open(Tag.title).append(title).close(Tag.title);
    }

    public HtmlView meta() {
        return open(Tag.meta);
    }

    public HtmlView br() {
        return open(Tag.br);
    }

    @Override
    protected HtmlView self() {
        return this;
    }
}
