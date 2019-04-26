package com.sample.views;

import org.fluentness.view.View;
import org.fluentness.view.HtmlTag;
import org.fluentness.view.HtmlView;

public class HeadView implements View {

    @Override
    public String render() {

        return new HtmlView()
                .open(HtmlTag.head)
                .title("the best site")
                .meta().set("name", "lang").set("content", "es")
                .meta().set("charset", "utf-8")
                .includeJs("js/scripts.js")
                .includeCss("css/styles.css")
                .close(HtmlTag.head)
                .render();
    }
}
