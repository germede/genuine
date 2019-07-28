package org.fluentness.flow.provider;

import org.fluentness.base.common.annotation.DefinitionPriority;
import org.fluentness.flow.component.style.Style;
import org.fluentness.flow.component.style.StyleFactory;

@DefinitionPriority(2100)
public abstract class StyleProvider extends Provider<Style> implements StyleFactory {

    @Override
    public Class<Style> getComponentClass() {
        return Style.class;
    }

}
