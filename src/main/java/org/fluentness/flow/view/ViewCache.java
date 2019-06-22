package org.fluentness.flow.view;

import org.fluentness.Fluentness;
import org.fluentness.common.constants.PrivateDirectories;
import org.fluentness.common.generics.Cache;
import org.fluentness.flow.localization.Localizable;

public enum ViewCache implements Cache<View> {

    INSTANCE;

    public String getIdentifyingCacheFilePath(View view) {
        return PrivateDirectories.VIEW_CACHE + "/" +
            Fluentness.INSTANCE.views.getKeyForValue(view) + "." +
            Localizable.getCurrentLocale().toString() + ".html";
    }

}
