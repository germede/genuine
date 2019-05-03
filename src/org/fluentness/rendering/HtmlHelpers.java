package org.fluentness.rendering;

public interface HtmlHelpers {
    default CharSequence attrs(MarkupAttribute... attributes) {
        return new MarkupElement.Attributes(attributes);
    }
}
