package org.fluentness.templating;

import java.io.Serializable;

public class DomInner implements Serializable {
    private String text;

    public DomInner(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return text;
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
