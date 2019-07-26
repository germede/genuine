package ${package}.flow;

import org.fluentness.flow.producer.localization.Locale;
import org.fluentness.flow.producer.localization.LocaleProducer;

public class Locales extends LocaleProducer {

    Locale dummy = translations(
        dummy_message -> "Dummy message"
    );

}
