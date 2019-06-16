package org.fluentness.style;

import org.fluentness.common.caching.Cacheable;
import org.fluentness.common.components.Component;

public abstract class Style implements Component, Cacheable {

    @Override
    public String cache() {
        if (StyleCache.INSTANCE.doesCacheFileExists(this)) {
            return StyleCache.INSTANCE.retrieve(this);
        }

        String rendered = render();

        StyleCache.INSTANCE.store(this, rendered);

        return rendered;
    }

    abstract String render();

}
