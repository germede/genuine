package ${package}.flow;

import org.fluentness.flow.component.localization.Locale;
import org.fluentness.flow.component.localization.LocaleProducer;

public class Locales extends LocaleProducer {

    Locale dummy = translations(
        dummy_message -> "Dummy message"
    );

}
