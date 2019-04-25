package com.sample.view;

import org.fwf.mvc.View;
import org.fwf.tpl.HtmlAttribute;
import org.fwf.tpl.HtmlTag;
import org.fwf.tpl.HtmlView;

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
