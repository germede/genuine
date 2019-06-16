package org.fluentness.view;

import org.fluentness.Fluentness;
import org.fluentness.common.caching.Cache;
import org.fluentness.common.constants.PrivateDirectories;
import org.fluentness.localization.Localizable;

public enum ViewCache implements Cache<View> {
    INSTANCE;

    @Override
    public String getIdentifyingCacheFilePath(View view) {
        return PrivateDirectories.VIEW_CACHE + "/" +
            Fluentness.INSTANCE.views.getKeyForValue(view) + "." +
            Localizable.getCurrentLocale().toString() + ".html";
    }
}
