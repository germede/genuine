package org.fluentness.localization;

import org.fluentness.singleton.ClassRegister;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ViewLocalizator implements Localizator{

    private String language;

    public ViewLocalizator(String language) {
        this.language = language.toLowerCase();
    }

    public String localize(String string) {
        StringBuilder result = new StringBuilder(string);
        Localization.Translations translations = ClassRegister.getTranslations().get(language);
        if (translations != null) {
            Matcher matcher = Pattern.compile("LLL:(\\w+)#").matcher(result);
            while (matcher.find()) {
                String key = matcher.group(1);
                if (translations.contains(key)) {
                    result.replace(matcher.start(), matcher.end(), translations.get(key));
                }
            }
        }
        return result.toString();
    }
}
