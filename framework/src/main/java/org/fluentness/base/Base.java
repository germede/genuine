package org.fluentness.base;

import org.fluentness.base.common.Architecture;
import org.fluentness.base.service.Service;

public class Base extends Architecture<Service> {

    static Base instance;

    public Base() {
        instance = this;
    }

    @Override
    protected Class<? extends Service>[] getKeysThatWillPointTo(Service instance) {
        return (Class<? extends Service>[]) array(
            instance.getClass().getInterfaces()[0],
            instance.getClass()
        );
    }
}
