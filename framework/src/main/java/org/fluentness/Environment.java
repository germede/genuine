package org.fluentness;

import org.fluentness.base.Base;
import org.fluentness.base.common.exception.DefinitionException;
import org.fluentness.data.Data;
import org.fluentness.flow.Flow;

public interface Environment {

    void define(Base base) throws DefinitionException;

    void define(Data data) throws DefinitionException;

    void define(Flow flow) throws DefinitionException;

}