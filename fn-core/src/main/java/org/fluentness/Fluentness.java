package org.fluentness;

import org.fluentness.service.injection.FinalInjection;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class Fluentness {

    public static final Map<Class, Object> instances = new HashMap<>();

    public static <A extends ApplicationComponent> List<A> getInstances(Class<A> parent) {
        List<A> list = new ArrayList<>();
        for (Object value : instances.values()) {
            if (parent.isAssignableFrom(value.getClass())) {
                list.add((A) value);
            }
        }
        return list;
    }

    public static <A extends ApplicationComponent> A getInstance(Class<A> parent) {
        return (A) instances.get(parent);
    }

    public static Fluentness launch(Application application, String... args) throws FluentnessException {
        return new Fluentness(application, args);
    }

    private Fluentness(Application application, String[] args) throws FluentnessException {
        try {

            new FinalInjection(application).inject();
            Map<Class, Object> instances = Fluentness.instances;
            application.run(args);
        } catch (Throwable cause) {
            throw new FluentnessException(cause);
        }
    }
}