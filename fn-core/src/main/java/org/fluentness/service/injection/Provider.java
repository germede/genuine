package org.fluentness.service.injection;

import org.fluentness.ApplicationComponent;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Provider<A extends ApplicationComponent> {

    private List<Class<? extends A>> components;

    public Provider(Class<A>[] services) {
        components = Arrays.asList(services);
    }

    public Provider<A> add(Class<? extends A> aClass) {
        components.add(aClass);
        return this;
    }

    List<Class<? extends A>> get() {
        Collections.reverse(components);
        return components;
    }
}
