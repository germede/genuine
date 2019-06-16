package org.fluentness.view;

import org.fluentness.Fluentness;
import org.fluentness.common.constants.PublicDirectories;
import org.fluentness.style.Style;

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
        String path = PublicDirectories.STYLES + "/" + Fluentness.INSTANCE.styles.getKeyForValue(style) + ".css";
        if (!new File(path).exists()) {
            style.writeToFile(path);
        }
        return link(REL -> "stylesheet", TYPE -> "text/css", HREF -> "/" + path);
    }

}
