package org.fluentness.flow;

import org.fluentness.flow.component.Component;
import org.fluentness.flow.provider.Provider;

public interface FlowConsumer {

    default boolean canProviderBeConsumed(Class<?> key) {
        return Flow.instance.has(key);
    }

    default <P extends Provider> P consumeProvider(Class<P> provider) {
        return (P) Flow.instance.get(provider);
    }

    default <C extends Component> Provider<C> consumeProviderByComponent(Class<C> component) {
        return Flow.instance.get(component);
    }
}
