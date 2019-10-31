package org.fluentness.controller.web.markup.html;

import org.fluentness.controller.web.markup.ContainerMarkupView;
import org.fluentness.controller.web.markup.MarkupView;

public class ContainerHtmlView extends ContainerMarkupView implements HtmlView {

    public ContainerHtmlView(String tag, MarkupView... inner) {
        super(tag, inner);
    }

    public ContainerHtmlView(String tag, String inner) {
        super(tag,inner);
    }

    @Override
    public HtmlView attr(String key, String value) {
        attributes.put(key,value);
        return this;
    }
}
