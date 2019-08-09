package org.fluentness.flow.view;

import org.fluentness.base.common.lambda.KeyValuePairLambda;

public class MarkupElementEmpty extends MarkupElement {

    protected MarkupElementEmpty(String tag, KeyValuePairLambda<String>... attributes) {
        super(false);
        this.tag = tag;
        this.attributes = new MarkupAttributes(attributes);
    }

}
