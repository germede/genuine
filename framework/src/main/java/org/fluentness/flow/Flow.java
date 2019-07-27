package org.fluentness.flow;

import org.fluentness.base.common.Architecture;
import org.fluentness.flow.provider.Provider;

public class Flow extends Architecture<Provider> {

    static Flow instance;

    public Flow() {
        instance = this;
    }

    @Override
    protected Class<? extends Provider>[] getKeysThatWillPointTo(Provider instance) {
        return array(
            instance.getComponentClass(),
            (Class<? extends Provider>) instance.getClass().getSuperclass(),
            instance.getClass()
        );
    }
}
