package org.fluentness.flow.view;

import org.fluentness.Fluentness;
import org.fluentness.common.constants.PrivateDirectories;
import org.fluentness.common.generics.Cache;
import org.fluentness.common.networking.HttpRequestRegister;

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
