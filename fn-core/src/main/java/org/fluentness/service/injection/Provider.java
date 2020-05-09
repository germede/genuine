package org.fluentness.service.injection;

import org.fluentness.ApplicationComponent;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public  class Provider<A extends ApplicationComponent> {

    private List<Class<?extends A>> components = new LinkedList<>();

    public Provider<A> add(Class<? extends A> aClass) {
        components.add(aClass);
        return this;
    }

    List<Class<?extends A>> get() {
        Collections.reverse(components);
        return components;
    }
}
