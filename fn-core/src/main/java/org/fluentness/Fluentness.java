package org.fluentness;

import org.fluentness.service.injection.InjectionImpl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class Fluentness {

    public static final Map<Class, Object> instances = new HashMap<>();

    public static <A extends Application.Component> List<A> getInstances(Class<A> parent) {
        List<A> list = new ArrayList<>();
        for (Object value : instances.values()) {
            if (parent.isAssignableFrom(value.getClass())) {
                list.add((A) value);
            }
        }
        return list;
    }

    public static <A extends Application.Component> A getInstance(Class<A> parent) {
        return (A) instances.get(parent);
    }

    public static Fluentness launch(Application application, String... args) throws FluentnessException {
        return new Fluentness(application, args);
    }

    private Fluentness(Application application, String[] args) throws FluentnessException {
        try {
            new InjectionImpl(application).inject();
            Map<Class, Object> instances = Fluentness.instances;
            application.run(args);
        } catch (Throwable cause) {
            throw new FluentnessException(cause);
        }
    }
}