package org.fluentness.service.injection.initer;

import org.fluentness.ApplicationComponent;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

abstract class Initer<A extends ApplicationComponent> {

    private List<Class<?extends A>> components = new LinkedList<>();

    public void set(Class<? extends A>... classes) {
        components.addAll(Arrays.asList(classes));
    }

    public List<Class<?extends A>> get() {
        return components;
    }
}
