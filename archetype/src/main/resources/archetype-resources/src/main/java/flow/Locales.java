package ${package}.flow;

import org.fluentness.controller.i18n.Locale;
import org.fluentness.controller.i18n.LocaleProducer;

public class Locales extends LocaleProducer {

    Locale dummy = translations(
        dummy_message -> "Dummy message"
    );

}
