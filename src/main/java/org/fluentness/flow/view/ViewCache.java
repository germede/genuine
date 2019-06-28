package org.fluentness.flow.view;

import org.fluentness.Fluentness;
import org.fluentness.base.constants.PrivateDirectories;
import org.fluentness.base.generics.Cache;
import org.fluentness.base.networking.HttpRequestRegister;

public enum ViewCache implements Cache<View> {

    INSTANCE;

    @Override
    public String getIdentifyingCacheFilePath(View view) {
        return PrivateDirectories.VIEW_CACHE + "/" +
            Fluentness.INSTANCE.views.getKeyForValue(view) + "." +
            HttpRequestRegister.getCurrentLocale().toString() + ".html";
    }

    @Override
    public boolean isCacheable(View view) {
        return !view.hasParameters();
    }

}
