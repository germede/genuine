package com.sample.view;

import org.fwf.mvc.View;
import org.fwf.tpl.HtmlTag;
import org.fwf.tpl.HtmlView;

public class HeadView implements View {

    @Override
    public String render() {

        return new HtmlView()
                .open(HtmlTag.head)
                .title("the best site")
                .close(HtmlTag.head)
                .render();
    }
}
