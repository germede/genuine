package org.fluentness.view;

import org.fluentness.common.Provider;
import org.fluentness.localization.Localizable;

public interface ViewProvider extends Provider<View>, Localizable, HtmlFunctions {

    default String placeholder(View view) {
        return view.render();
    }

}
