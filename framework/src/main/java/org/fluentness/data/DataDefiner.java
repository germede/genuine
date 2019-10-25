package org.fluentness.data;

import org.fluentness.base.exception.DefinitionException;

@FunctionalInterface
public interface DataDefiner {
    void define(Data data) throws DefinitionException;
}
