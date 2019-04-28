package org.fluentness.templating;

import java.io.Serializable;

public class DomAttribute implements Serializable {

    private final String key;
    private final String value;

    public DomAttribute(String key, String value) {
        this.key = key;
        this.value = value;
    }

    @Override
    public String toString() {
        return key + "=\"" + value + "\"";
    }

    //    @Override
//    public String render() {
//
//         translate
//        Translations translations = ClassRegister.getTranslations().get(language);
//        if (translations != null) {
//            Matcher matcher = Pattern.compile("###(\\w+)###").matcher(document);
//            while (matcher.find()) {
//                String key = matcher.group(1);
//                if (translations.contains(key)) {
//                    document.replace(matcher.start(),matcher.end(),translations.get(key));
//                }
//            }
//        }
//        return document.toString();
//    }
}
