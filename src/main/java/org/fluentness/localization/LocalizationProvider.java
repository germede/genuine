package org.fluentness.localization;

import org.fluentness.FnAtoz;
import org.fluentness.common.lambdas.NamedValue;
import org.fluentness.common.Provider;

import java.util.Collection;
import java.util.Locale;
import java.util.stream.Collectors;

public interface LocalizationProvider extends Provider<Localization> {


    default Localization translations(NamedValue<String>... translations) {
        return new Localization(translations);
    }

}
