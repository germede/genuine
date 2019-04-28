package org.fluentness.templating;

import java.io.Serializable;

public class DomElement implements Serializable {

    private StringBuilder html;

    public DomElement(String tag, Serializable[] renderables, boolean isContainer) {
        this.html = new StringBuilder();

        open(tag);
        appendAttributes(renderables);
        appendInner(renderables);
        if (isContainer) {
            close(tag);
        }
    }

    private void open(String tag) {
        html.append("<").append(tag).append(">");
    }

    private void appendAttributes(Serializable[] renderables) {
        for (Serializable renderable : renderables) {
            if (renderable instanceof DomAttribute) {
                html.replace(html.length() - 1, html.length(), " " + renderable.toString() + ">");
            }
        }
    }

    private void appendInner(Serializable[] renderables) {
        for (Serializable renderable : renderables) {
            if (!(renderable instanceof DomAttribute)) {
                html.append(renderable.toString());
            }
        }
    }

    private void close(String tag) {
        html.append("</").append(tag).append(">");
    }

    @Override
    public String toString() {
        return html.toString();
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
