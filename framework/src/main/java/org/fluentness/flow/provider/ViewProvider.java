package org.fluentness.flow.provider;

import org.fluentness.flow.component.view.View;
import org.fluentness.flow.component.view.ViewFactory;

public abstract class ViewProvider extends Provider<View> implements ViewFactory {

    @Override
    public int getDefinitionPriority() {
        return 2300;
    }

    @Override
    public Class<View> getComponentClass() {
        return View.class;
    }

}
