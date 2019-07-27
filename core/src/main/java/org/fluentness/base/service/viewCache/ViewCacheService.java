package org.fluentness.base.service.viewCache;

import org.fluentness.base.service.Service;
import org.fluentness.flow.component.view.View;

public interface ViewCacheService extends Service {

    @Override
    default int getDefinitionPriority() {
        return 400;
    }

    String cache(View view);

    boolean doesCacheFileExists(View view);

    void store(View view, String content);

    String retrieve(View t);
}
