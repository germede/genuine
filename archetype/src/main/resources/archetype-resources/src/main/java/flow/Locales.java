package ${package}.flow;

import org.fluentness.service.Provider.localization.Locale;
import org.fluentness.service.Provider.localization.LocaleProducer;

public class Locales extends LocaleProducer {

    Locale dummy = translations(
        dummy_message -> "Dummy message"
    );

}
