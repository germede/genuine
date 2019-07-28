package org.fluentness.flow;

import org.fluentness.Fluentness;
import org.fluentness.base.common.Architecture;
import org.fluentness.flow.component.Component;
import org.fluentness.flow.provider.Provider;

public final class Flow extends Architecture<Provider> {

    // per definition a singleton, can only be accessed via consumer
    private final static Flow instance = new Flow();

    // public but safe, as fluentness instance is required, which has private constructor
    public static Flow getInstance(Fluentness proxy) {
        return instance;
    }

    // avoids unintended instantiations
    private Flow() {

    }

    @Override
    protected Class<Provider> getIClass() {
        return Provider.class;
    }

    @Override
    protected Class<? extends Provider>[] getKeysThatWillPointTo(Provider instance) {
        return array(
            instance.getComponentClass(),
            (Class<? extends Provider>) instance.getClass().getSuperclass(),
            instance.getClass()
        );
    }

    public interface Consumer {

        default boolean canProviderBeConsumed(Class<?> key) {
            return instance.has(key);
        }

        default <P extends Provider> P provider(Class<P> provider) {
            return (P) instance.get(provider);
        }

        default <C extends Component> Provider<C> consumeProviderByComponent(Class<C> component) {
            return instance.get(component);
        }
    }
}
