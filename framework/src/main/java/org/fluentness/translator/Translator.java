package org.fluentness.translator;

import org.fluentness.ApplicationComponent;

public interface Translator extends ApplicationComponent {

    String translate(Translation translation);

}
