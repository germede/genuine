package org.fluentness.flow.producer.view;

import org.fluentness.base.common.constant.PublicDirectories;
import org.fluentness.flow.producer.style.Style;

import java.io.File;

public interface HtmlFunctions extends
    MarkupFunctions,
    HtmlFunctionsEmpty,
    HtmlFunctionsContainerView,
    HtmlFunctionsContainerString,
    HtmlFunctionsContainerAttributesView,
    HtmlFunctionsContainerAttributesString {


    default MarkupElementContainer includeJs(String src) {
        return script(attrs(SRC -> "/" + PublicDirectories.JS + "/" + src));
    }

    default MarkupElementEmpty style(Style style) {
        String path = PublicDirectories.STYLES + "/" + style.getName() + ".css";
        if (!new File(path).exists()) {
            style.writeToFile(path);
        }
        return link(REL -> "stylesheet", TYPE -> "text/css", HREF -> "/" + path);
    }

}
