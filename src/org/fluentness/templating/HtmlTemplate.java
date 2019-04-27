package org.fluentness.templating;

import org.fluentness.Configuration;

public class HtmlTemplate extends MarkupTemplate<HtmlTemplate> {

    @Override
    public HtmlTemplate self() {
        return this;
    }

    public HtmlTemplate includeCss(String path) {
        return open(HtmlTag.link)
                .set("rel", "stylesheet")
                .set("type", "text/css")
                .set("href", Configuration.getString(Configuration.APP_URL).concat("/res/").concat(path));
    }

    public HtmlTemplate includeJs(String path) {
        return open(HtmlTag.script)
                .set("src", Configuration.getString(Configuration.APP_URL).concat("/res/").concat(path))
                .close(HtmlTag.script);
    }

    public HtmlTemplate title(String title) {
        return open(HtmlTag.title).append(title).close(HtmlTag.title);
    }

    public HtmlTemplate meta() {
        return open(HtmlTag.meta);
    }

    public HtmlTemplate br() {
        return open(HtmlTag.br);
    }
}
