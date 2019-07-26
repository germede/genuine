package org.fluentness.flow.producer.view;

import org.fluentness.base.common.lambda.KeyValuePair;

public class MarkupElementEmpty extends MarkupElement {

    protected MarkupElementEmpty(String tag, KeyValuePair<String>... attributes) {
        super(false);
        this.tag = tag;
        this.attributes = new MarkupAttributes(attributes);
    }

}
