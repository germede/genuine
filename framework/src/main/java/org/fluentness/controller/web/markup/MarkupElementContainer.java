package org.fluentness.controller.web.markup;

import org.fluentness.controller.web.WebView;

public class MarkupElementContainer extends MarkupElement {

    protected MarkupElementContainer(String tag, WebView... innerViews) {
        super(true);
        this.tag = tag;
        this.innerViews = innerViews;
    }

    protected MarkupElementContainer(String tag, String innerText) {
        super(true);
        this.tag = tag;
        this.innerText = innerText;
    }

    protected MarkupElementContainer(String tag, MarkupAttributes attributes, WebView[] innerViews) {
        super(true);
        this.tag = tag;
        this.attributes = attributes;
        this.innerViews = innerViews;
    }

    protected MarkupElementContainer(String tag, MarkupAttributes attributes, String innerText) {
        super(true);
        this.tag = tag;
        this.attributes = attributes;
        this.innerText = innerText;
    }
}
