package ${package}.flow;

import org.fluentness.base.service.localization.Locale;
import org.fluentness.base.service.localization.LocaleProducer;

public class Locales extends LocaleProducer {

    Locale dummy = translations(
        dummy_message -> "Dummy message"
    );

}
