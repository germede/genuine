package org.fluentness.style;

import org.fluentness.Fluentness;
import org.fluentness.common.constants.PublicDirectories;
import org.fluentness.common.caching.Cache;

public enum StyleCache implements Cache<Style> {
    INSTANCE;

    @Override
    public String getIdentifyingCacheFilePath(Style style) {
        return PublicDirectories.STYLE_CACHE + "/" + Fluentness.INSTANCE.styles.getKeyForValue(style) + ".min.css";
    }
}
