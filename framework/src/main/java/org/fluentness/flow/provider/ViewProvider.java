package org.fluentness.flow.provider;

import org.fluentness.base.common.annotation.DefinitionPriority;
import org.fluentness.flow.component.view.View;
import org.fluentness.flow.component.view.ViewFactory;

@DefinitionPriority(2300)
public abstract class ViewProvider extends Provider<View> implements ViewFactory {

    @Override
    public Class<View> getComponentClass() {
        return View.class;
    }

}
