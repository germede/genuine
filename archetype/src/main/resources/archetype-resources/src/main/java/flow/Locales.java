package ${package}.flow;

import org.fluentness.service.localization.Locale;
import org.fluentness.service.localization.LocaleProducer;

public class Locales extends LocaleProducer {

    Locale dummy = translations(
        dummy_message -> "Dummy message"
    );

}
