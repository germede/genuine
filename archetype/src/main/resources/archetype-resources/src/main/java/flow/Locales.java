package ${package}.flow;

import org.fluentness.service.translator.Locale;
import org.fluentness.service.translator.LocaleProducer;

public class Locales extends LocaleProducer {

    Locale dummy = translations(
        dummy_message -> "Dummy message"
    );

}
