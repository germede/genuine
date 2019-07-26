package org.fluentness.base;

import org.fluentness.base.common.Architecture;
import org.fluentness.base.service.Service;

import java.util.Map;

public class Base extends Architecture<Service> {

    private static Base instance;

    Base(Map<Class<Service>, Service> applied) {
        super(applied);
        instance = this;
    }

    public interface Consumer {
        static <S extends Service> S base(Class<S> service) {
            return (S) instance.instances.get(service);
        }
    }
}
