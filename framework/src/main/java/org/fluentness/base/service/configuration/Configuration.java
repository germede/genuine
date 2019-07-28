package org.fluentness.base.service.configuration;

import org.fluentness.base.common.annotation.DefinitionPriority;
import org.fluentness.base.service.Service;

@DefinitionPriority(0)
public interface Configuration extends Service {

    <T> boolean has(Key<T> key);

    <T> T get(Key<T> key);

    <T> Configuration set(Key<T> key, T value);

}
