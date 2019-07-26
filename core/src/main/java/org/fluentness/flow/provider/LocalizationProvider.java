package org.fluentness.flow.provider;

import org.fluentness.flow.provider.localization.Localization;

public abstract class LocalizationProvider extends Provider<Localization> {

    @Override
    public Class<Localization> getProducedComponentType() {
        return Localization.class;
    }


}
