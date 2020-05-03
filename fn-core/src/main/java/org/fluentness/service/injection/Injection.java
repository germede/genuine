package org.fluentness.service.injection;

import org.fluentness.Application;
import org.fluentness.ApplicationComponent;
import org.fluentness.service.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface Injection extends Service {

    Map<Class, Object> instances = new HashMap<>();

    static <A extends ApplicationComponent> List<A> getInstances(Class<A> parent) {
        List<A> list = new ArrayList<>();
        for (Object value : instances.values()) {
            if (parent.isAssignableFrom(value.getClass())) {
                list.add((A) value);
            }
        }
        return list;
    }

    static <A extends ApplicationComponent> A getInstance(Class<A> parent) {
        return (A) instances.get(parent);
    }

    Application.Platform inject(Application application) throws InjectionException;

}
