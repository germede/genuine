package org.fluentness.view;

import org.fluentness.Fluentness;
import org.fluentness.base.constants.PrivateDirectories;
import org.fluentness.base.generics.Cache;

public enum ViewCache implements Cache<View> {
    INSTANCE;

    @Override
    public String getIdentifyingPath(View view) {
        return PrivateDirectories.VIEW_CACHE + "/" + Fluentness.INSTANCE.views.getKeyForValue(view) + ".html";    }
}
