package ${package}.flow;

import org.fluentness.base.Provider.localization.Locale;
import org.fluentness.base.Provider.localization.LocaleProducer;

public class Locales extends LocaleProducer {

    Locale dummy = translations(
        dummy_message -> "Dummy message"
    );

}
