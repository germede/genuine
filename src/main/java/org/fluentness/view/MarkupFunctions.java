package org.fluentness.view;

import org.fluentness.common.lambdas.KeyValuePair;

interface MarkupFunctions {

    default MarkupAttributes attrs(KeyValuePair<String>... attributes) {
        return new MarkupAttributes(attributes);
    }

}
