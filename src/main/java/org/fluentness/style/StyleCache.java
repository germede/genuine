package org.fluentness.style;

import org.fluentness.Fluentness;
import org.fluentness.base.constants.PublicDirectories;
import org.fluentness.base.generics.Cache;

public enum StyleCache implements Cache<Style> {
    INSTANCE;

    @Override
    public String getIdentifyingPath(Style style) {
        return PublicDirectories.STYLE_CACHE + "/" + Fluentness.get.styles.getNameFor(style) + ".min.css";
    }
}
