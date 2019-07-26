package org.fluentness.flow.provider;

import org.fluentness.flow.provider.view.View;

public abstract class ViewProvider extends Provider<View> {

    @Override
    public Class<View> getProducedComponentType() {
        return View.class;
    }


}
