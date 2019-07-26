package org.fluentness.flow.provider;

import org.fluentness.flow.provider.style.Style;
import org.fluentness.flow.provider.style.StyleFactory;

public abstract class StyleProvider extends Provider<Style> implements StyleFactory {

    @Override
    public Class<Style> getProducedComponentType() {
        return Style.class;
    }

}
