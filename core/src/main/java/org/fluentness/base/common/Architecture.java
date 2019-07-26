package org.fluentness.base.common;

import java.util.Map;

public abstract class Architecture<T> {

    protected final Map<Class<T>, T> instances;

    protected Architecture(Map<Class<T>, T> instances) {
        this.instances = instances;
    }
}
