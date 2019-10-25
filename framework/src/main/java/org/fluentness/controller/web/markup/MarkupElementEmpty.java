package org.fluentness.controller.web.markup;

import org.fluentness.service.common.lambda.KeyValuePairLambda;

public class MarkupElementEmpty extends MarkupElement {

    protected MarkupElementEmpty(String tag, KeyValuePairLambda<String>... attributes) {
        super(false);
        this.tag = tag;
        this.attributes = new MarkupAttributes(attributes);
    }

}
