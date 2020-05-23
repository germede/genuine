package org.fluentness.service.localization;

import org.fluentness.service.Service;

public interface Localization extends Service {

    default String localize(Translation translation) {
        return translation.toString();
    }

}
