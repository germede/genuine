package org.fluentness.controller.web.html;

import org.fluentness.service.common.lambda.KeyValuePairLambda;
import org.fluentness.controller.web.WebView;
import org.fluentness.controller.component.style.Style;
import org.fluentness.controller.web.control.ForEachView;
import org.fluentness.controller.web.markup.MarkupAttributes;
import org.fluentness.controller.web.markup.MarkupElementContainer;
import org.fluentness.controller.web.markup.MarkupElementEmpty;
import org.fluentness.controller.web.text.RawView;

import java.io.File;
import java.util.function.Function;

public final class HtmlViewFactory implements
        EmptyHtmlViewFactory,
        ContainerHtmlViewFactory,
        ContainerStringHtmlViewFactory,
        ContainerAttributesHtmlViewFactory,
        ContainerAttributesStringHtmlViewFactory {

    public static MarkupAttributes attrs(KeyValuePairLambda<String>... attributes) {
        return new MarkupAttributes(attributes);
    }

    public static WebView raw(String raw) {
        return new RawView(raw);
    }


    public static <T> WebView forEachItemIn(String parameter, Class<T> itemClass, Function<T, WebView> function) {
        return new ForEachView(parameter, function);
    }


    public static MarkupElementContainer includeJs(String src) {
        return script(attrs(SRC -> "/" + src));
    }

    public static MarkupElementEmpty style(Style style) {
        String path = "/" + style.toString() + ".css";
        if (!new File(path).exists()) {
            style.writeToFile(path);
        }
        return link(REL -> "stylesheet", TYPE -> "text/css", HREF -> "/" + path);
    }
}
