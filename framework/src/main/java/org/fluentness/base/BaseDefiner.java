package org.fluentness.base;

import org.fluentness.base.exception.DefinitionException;

@FunctionalInterface
public interface BaseDefiner {
    void define(Base base) throws DefinitionException;
}
