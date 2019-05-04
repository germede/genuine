package org.fluentness.rendering;

import org.fluentness.common.NamedValue;

public interface HtmlHelpers {
    default CharSequence attrs(NamedValue... attributes) {
        return new MarkupElement.Attributes(attributes);
    }
}
