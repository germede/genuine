package org.fluentness.controller.web.html;

import org.fluentness.controller.web.WebView;
import org.fluentness.controller.web.markup.MarkupAttributes;
import org.fluentness.controller.web.text.RawView;

public final class HtmlViewFactory extends HtmlViewFactory1 {

    public static MarkupAttributes attrs(String... attributes) {
        return new MarkupAttributes(attributes);
    }

    public static WebView raw(String raw) {
        return new RawView(raw);
    }

//
//    public static <T> WebView forEachItemIn(String parameter, Class<T> itemClass, Function<T, WebView> function) {
//        return new ForEachView(parameter, function);
//    }
//
//
//    public static MarkupElementContainer includeJs(String src) {
//        return script(attrs(SRC -> "/" + src));
//    }
//
//    public static MarkupElementEmpty style(Style style) {
//        String path = "/" + style.toString() + ".css";
//        if (!new File(path).exists()) {
//            style.writeToFile(path);
//        }
//        return link(REL -> "stylesheet", TYPE -> "text/css", HREF -> "/" + path);
//    }
}
