package com.sample.views;

import org.fluentworkflow.mvc.View;
import org.fluentworkflow.tpl.HtmlAttribute;
import org.fluentworkflow.tpl.HtmlTag;
import org.fluentworkflow.tpl.HtmlView;

public class HeadView implements View {

    @Override
    public String render() {

        return new HtmlView()
                .open(HtmlTag.head)
                .title("the best site")
                .meta(new HtmlAttribute("name", "lang"), new HtmlAttribute("content", "es"))
                .meta(new HtmlAttribute("charset", "utf-8"))
                .includeCss("css/styles.css")
                .includeJs("js/scripts.js")
                .close(HtmlTag.head)
                .render();
    }
}
