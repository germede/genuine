package org.fluentness.flow;

import org.fluentness.base.common.Architecture;
import org.fluentness.flow.provider.Provider;

import java.util.Map;

public class Flow extends Architecture<Provider> {

    private static Flow instance;

    Flow(Map<Class<Provider>, Provider> instances) {
        super(instances);
        instance = this;
    }

    public interface Consumer {
        static <P extends Provider> P provider(Class<P> provider) {
            return (P) instance.instances.get(provider);
        }
    }
}
