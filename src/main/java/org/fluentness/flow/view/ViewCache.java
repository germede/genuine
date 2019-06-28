package org.fluentness.flow.view;

import org.fluentness.base.constants.PrivateDirectories;
import org.fluentness.base.generics.Cache;
import org.fluentness.base.networking.HttpRequestRegister;

public enum ViewCache implements Cache<View> {

    call;

    @Override
    public String getIdentifyingCacheFilePath(View view) {
        return PrivateDirectories.VIEW_CACHE + "/" +
            view.getName() + "." +
            HttpRequestRegister.getCurrentLocale().toString() + ".html";
    }

    @Override
    public boolean isCacheable(View view) {
        return !view.hasParameters();
    }

}
