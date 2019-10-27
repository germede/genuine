package org.fluentness.controller.web.markup;

public class MarkupElementEmpty extends MarkupElement {

    public MarkupElementEmpty(String tag, String... attributes) {
        super(false);
        this.tag = tag;
        this.attributes = new MarkupAttributes(attributes);
    }

}
