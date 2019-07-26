package org.fluentness.base;

import org.fluentness.base.service.Service;

import java.util.Map;

public final class Base {

    private final Map<Class<Service>, Service> services;

    Base(Map<Class<Service>, Service> services) {
        this.services = services;
    }

    public <S extends Service> S getService(Class<S> serviceClass) {
        return (S) services.get(serviceClass);
    }

}
