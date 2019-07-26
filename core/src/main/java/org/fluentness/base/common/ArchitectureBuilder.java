package org.fluentness.base.common;

import org.fluentness.base.common.exception.BuildException;

import java.util.LinkedHashMap;
import java.util.Map;

public abstract class ArchitectureBuilder<A extends Architecture, T> {

    protected final Map<Class<T>, T> instances = new LinkedHashMap<>();

    public ArchitectureBuilder<A, T> add(Class<? extends T> tClass, T implementation) throws BuildException {
        validate((Class<T>) tClass,implementation);
        instances.put((Class<T>) tClass, implementation);
        return this;
    }

    protected abstract void validate(Class<T> key, T value) throws BuildException;

    public abstract A build();
}
