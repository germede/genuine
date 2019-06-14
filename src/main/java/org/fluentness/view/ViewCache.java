package org.fluentness.view;

import org.fluentness.base.constants.PrivateDirectories;
import org.fluentness.base.generics.Cache;

import static org.fluentness.base.components.Components.views;

public enum ViewCache implements Cache<View> {
    INSTANCE;

    @Override
    public String getIdentifyingPath(View view) {
        return PrivateDirectories.VIEW_CACHE + "/" + View.class.getSimpleName() + "/" + views().getNameFor(view) + ".html";
    }
}
