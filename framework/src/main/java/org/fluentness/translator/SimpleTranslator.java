package org.fluentness.translator;

import java.util.Locale;

public class SimpleTranslator implements Translator {

    @Override
    public String translate(Translation translation) {
        return translation.translate(Language.valueOf(Locale.getDefault().getLanguage()));
    }
}
