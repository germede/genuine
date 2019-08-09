package ${package}.flow;

import org.fluentness.base.provider.localization.Locale;
import org.fluentness.base.provider.localization.LocaleProducer;

public class Locales extends LocaleProducer {

    Locale dummy = translations(
        dummy_message -> "Dummy message"
    );

}
