package org.fluentness.view;

import org.fluentness.common.constants.PublicDirectories;
import org.fluentness.style.Style;
import org.fluentness.style.StyleCache;

public interface HtmlFunctions extends
    MarkupFunctions,
    HtmlFunctionsEmpty,
    HtmlFunctionsContainerView,
    HtmlFunctionsContainerString,
    HtmlFunctionsContainerAttributesView,
    HtmlFunctionsContainerAttributesString {

    default MarkupElementEmpty includeCss(String href) {
        return link(REL -> "stylesheet", TYPE -> "text/css", HREF -> href);
    }

    default MarkupElementContainer includeJs(String src) {
        return script(attrs(SRC -> "/" + PublicDirectories.JS + "/" + src));
    }

    default MarkupElementEmpty include(Style style) {
        style.cache();
        return link(REL -> "stylesheet", TYPE -> "text/css", HREF -> "/" + StyleCache.INSTANCE.getIdentifyingCacheFilePath(style));
    }

}
