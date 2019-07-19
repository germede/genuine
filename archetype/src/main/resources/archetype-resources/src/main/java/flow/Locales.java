package ${package}.flow;

import org.fluentness.flow.locale.Locale;
import org.fluentness.flow.locale.LocaleProvider;

public class Locales extends LocaleProvider {

    Locale dummy = translations(
        dummy_message -> "Dummy message"
    );

}
