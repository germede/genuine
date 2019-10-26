package org.fluentness.controller.web.markup;

public class MarkupElementEmpty extends MarkupElement {

    protected MarkupElementEmpty(String tag, String... attributes) {
        super(false);
        this.tag = tag;
        this.attributes = new MarkupAttributes(attributes);
    }

}
