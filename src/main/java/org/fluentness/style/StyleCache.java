package org.fluentness.style;

import org.fluentness.base.constants.PublicDirectories;
import org.fluentness.base.generics.Cache;

import static org.fluentness.base.components.Components.styles;

public enum StyleCache implements Cache<Style> {
    INSTANCE;

    @Override
    public String getIdentifyingPath(Style style) {
        return PublicDirectories.STYLE_CACHE + "/" + styles().getNameFor(style) + ".min.css";
    }
}
