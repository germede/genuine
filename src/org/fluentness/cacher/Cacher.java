package org.fluentness.cacher;

import org.fluentness.common.Configuration;

public interface Cacher {

    String cache();
    boolean isCacheable();
    String getCacheIdentifier();
    String getCacheDirectory();

    default boolean isCacheEnabled() {
        return Configuration.getBoolean(Configuration.CACHE_ENABLE);
    }
}
