package ${package}.flow;

import org.fluentness.service.translation.Locale;
import org.fluentness.service.translation.LocaleProducer;

public class Locales extends LocaleProducer {

    Locale dummy = translations(
        dummy_message -> "Dummy message"
    );

}
