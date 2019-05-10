package org.fluentness.cacher;

import org.fluentness.configuration.Configuration;

public interface Cacher {

    String cache();
    boolean isCacheable();
    String getCacheIdentifier();
    String getCacheDirectory();

    default boolean isCacheEnabled() {
        return Configuration.getBoolean(Configuration.CACHE_ENABLE);
    }
}
