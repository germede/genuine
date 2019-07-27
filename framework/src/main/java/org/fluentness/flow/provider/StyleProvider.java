package org.fluentness.flow.provider;

import org.fluentness.flow.component.style.Style;
import org.fluentness.flow.component.style.StyleFactory;

public abstract class StyleProvider extends Provider<Style> implements StyleFactory {

    @Override
    public int getDefinitionPriority() {
        return 2100;
    }

    @Override
    public Class<Style> getComponentClass() {
        return Style.class;
    }

}
