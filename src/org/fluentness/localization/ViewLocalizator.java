package org.fluentness.localization;

import org.fluentness.common.ClassRegister;

public class ViewLocalizator implements Localizator{

    private String language;

    public ViewLocalizator(String language) {
        this.language = language.toLowerCase();
    }

    public String localize(String string) {
        StringBuilder result = new StringBuilder(string);
        Localization.Translations translations = ClassRegister.getTranslations().get(language);
        assert translations != null;

//        Matcher matcher = Pattern.compile("LLL:(\\w+)#").matcher(result);
//        while (matcher.find()) {
//            result.replace(matcher.start(), matcher.end(), translations.get(matcher.group(1)));
//        }
        return result.toString();
    }
}
