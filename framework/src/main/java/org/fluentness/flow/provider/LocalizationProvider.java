package org.fluentness.flow.provider;

import org.fluentness.base.common.annotation.DefinitionPriority;
import org.fluentness.flow.component.localization.Localization;
import org.fluentness.flow.component.localization.LocalizationFactory;

@DefinitionPriority(2000)
public abstract class LocalizationProvider extends Provider<Localization> implements LocalizationFactory {

    @Override
    public final Class<Localization> getComponentClass() {
        return Localization.class;
    }

}
