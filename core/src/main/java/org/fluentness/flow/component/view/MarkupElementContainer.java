package org.fluentness.flow.component.view;

public class MarkupElementContainer extends MarkupElement {

    protected MarkupElementContainer(String tag, View... innerViews) {
        super(true);
        this.tag = tag;
        this.innerViews = innerViews;
    }

    protected MarkupElementContainer(String tag, String innerText) {
        super(true);
        this.tag = tag;
        this.innerText = innerText;
    }

    protected MarkupElementContainer(String tag, MarkupAttributes attributes, View[] innerViews) {
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
