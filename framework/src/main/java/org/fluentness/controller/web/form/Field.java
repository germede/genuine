package org.fluentness.controller.web.form;


import org.fluentness.service.common.lambda.KeyValuePairLambda;
import org.fluentness.controller.web.markup.MarkupElement;
import org.fluentness.controller.web.markup.MarkupElementEmpty;
import org.fluentness.controller.web.WebView;

public class Field extends MarkupElementEmpty {

    Field(String fieldType, KeyValuePairLambda<String>[] attributes) {
        super("input", attributes);
        this.attributes.add(type -> fieldType);
    }

    public Field precededBy(WebView... predecessors) {
        return (Field) super.precededBy(predecessors);
    }

    public Field wrappedBy(MarkupElement wrapper) {
        return (Field) super.wrappedBy(wrapper);
    }

    public Field followedBy(WebView... successors) {
        return (Field) super.followedBy(successors);
    }

}
