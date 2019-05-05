package org.fluentness.cacher;

import org.fluentness.Fluentness;

public interface Cacher {

    String cache();
    boolean isCacheable();
    String getCacheIdentifier();
    String getCacheDirectory();

    default boolean isCacheEnabled() {
        return Fluentness.Configuration.getBoolean(Fluentness.Configuration.CACHE_ENABLE);
    }
}
