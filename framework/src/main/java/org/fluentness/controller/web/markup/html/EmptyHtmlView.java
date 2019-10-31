package org.fluentness.controller.web.markup.html;

import org.fluentness.controller.web.markup.EmptyMarkupView;

public class EmptyHtmlView extends EmptyMarkupView implements HtmlView {

    public EmptyHtmlView(String tag) {
        super(tag);
    }

    @Override
    public HtmlView attr(String key, String value) {
        attributes.put(key,value);
        return this;
    }
}
