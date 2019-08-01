package org.fluentness.flow.component.view;

import org.fluentness.base.common.lambda.KeyValuePairLambda;

interface MarkupFunctions {

    default MarkupAttributes attrs(KeyValuePairLambda<String>... attributes) {
        return new MarkupAttributes(attributes);
    }

}
