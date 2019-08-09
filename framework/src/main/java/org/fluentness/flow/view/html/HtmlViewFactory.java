package org.fluentness.flow.view.html;

import org.fluentness.base.common.lambda.KeyValuePairLambda;
import org.fluentness.flow.component.style.Style;
import org.fluentness.flow.view.*;
import org.fluentness.flow.view.control.ForEachView;

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

    public static View raw(String raw) {
        return new RawView(raw);
    }

    public static View print(String parameter) {
        return new ParameterView(parameter);
    }

    public static <T> View forEachItemIn(String parameter, Class<T> itemClass, Function<T, View> function) {
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
