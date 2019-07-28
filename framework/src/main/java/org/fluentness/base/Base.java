package org.fluentness.base;

import org.fluentness.Fluentness;
import org.fluentness.base.common.Architecture;
import org.fluentness.base.service.Service;

public final class Base extends Architecture<Service> {

    // per definition a singleton, can only be accessed via consumer
    private final static Base instance = new Base();

    // public but safe, as fluentness instance is required, which has private constructor
    public static Base getInstance(Fluentness proxy) {
        return instance;
    }

    // avoids unintended instantiations
    private Base() {

    }

    @Override
    protected Class<Service> getIClass() {
        return Service.class;
    }

    @Override
    protected Class<? extends Service>[] getKeysThatWillPointTo(Service instance) {
        return (Class<? extends Service>[]) array(
            instance.getClass().getInterfaces()[0],
            instance.getClass()
        );
    }

    public interface Consumer {

        default boolean canServiceBeConsumed(Class<? extends Service> service) {
            return instance.has(service);
        }

        default <S extends Service> S service(Class<S> service) {
            return (S) instance.get(service);
        }
    }
}
