package org.fluentness.flow.provider;

import org.fluentness.flow.component.localization.Localization;
import org.fluentness.flow.component.localization.LocalizationFactory;

public abstract class LocalizationProvider extends Provider<Localization> implements LocalizationFactory {

    @Override
    public int getDefinitionPriority() {
        return 2000;
    }

    @Override
    public Class<Localization> getComponentClass() {
        return Localization.class;
    }

}
