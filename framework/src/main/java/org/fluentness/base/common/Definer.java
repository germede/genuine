package org.fluentness.base.common;

import org.fluentness.base.Base;
import org.fluentness.base.common.exception.DefinitionException;
import org.fluentness.data.Data;
import org.fluentness.flow.Flow;

@FunctionalInterface
public interface Definer {
    void define(Base base, Data data, Flow flow) throws DefinitionException;
}
