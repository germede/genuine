package org.fluentness.caching;

import org.fluentness.FnConf;

public interface Cacher {

    String cache();
    boolean isCacheable();
    String getCacheIdentifier();
    String getCacheDirectory();

    default boolean isCacheEnabled() {
        return FnConf.getBoolean(FnConf.CACHE_ENABLE);
    }
}
