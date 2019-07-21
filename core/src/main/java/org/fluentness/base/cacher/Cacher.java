package org.fluentness.base.cacher;

import org.fluentness.flow.view.View;

public interface Cacher {
    void initialize();

    String cache(View view);

    boolean doesCacheFileExists(View view);

    void store(View view, String content);

    String retrieve(View t);
}
