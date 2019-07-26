package org.fluentness.flow.producer.view;

import org.fluentness.base.common.lambda.KeyValuePair;

interface MarkupFunctions {

    default MarkupAttributes attrs(KeyValuePair<String>... attributes) {
        return new MarkupAttributes(attributes);
    }

}
