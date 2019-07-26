package org.fluentness.flow.component.localization;

import org.fluentness.base.common.lambda.KeyValuePair;

public interface LocalizationFactory {

    default Localization translations(KeyValuePair<String>... translations) {
        return new Localization(translations);
    }

}
