package org.fluentness.base.service.cacher;

import org.fluentness.base.service.Service;
import org.fluentness.flow.provider.view.View;

public interface Cacher extends Service {
    void initialize();

    String cache(View view);

    boolean doesCacheFileExists(View view);

    void store(View view, String content);

    String retrieve(View t);
}
