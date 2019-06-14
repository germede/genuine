package org.fluentness.localization;

import org.fluentness.base.lambdas.KeyValuePair;
import org.fluentness.base.generics.Provider;

public interface LocalizationProvider extends Provider<Localization> {


    default Localization translations(KeyValuePair<String>... translations) {
        return new Localization(translations);
    }

}
