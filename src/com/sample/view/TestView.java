package com.sample.view;

import org.fwf.mvc.View;
import org.fwf.tpl.HtmlTag;
import org.fwf.tpl.HtmlView;

public class TestView extends View {

    private View template;

    public TestView(String testParameter) {
        this.template = new HtmlView()
                .open(HtmlTag.html)
                .raw(testParameter)
                .close(HtmlTag.html);
    }

    @Override
    public String render() {
        return template.render();
    }
}
