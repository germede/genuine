package com.sample.views;

import org.fluentness.view.View;
import org.fluentness.view.HtmlTag;
import org.fluentness.view.HtmlView;

public class HeadView implements View {

    @Override
    public String render() {

        return new HtmlView()
                .open(HtmlTag.head)
                .open(HtmlTag.title).append("the best site").close(HtmlTag.title)
                .open(HtmlTag.meta).set("name", "lang").set("content", "es")
                .open(HtmlTag.meta).set("charset", "utf-8")
                .includeJs("js/scripts.js")
                .includeCss("css/styles.css")
                .close(HtmlTag.head)
                .render();
    }
}
