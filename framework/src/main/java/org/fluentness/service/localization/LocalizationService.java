package org.fluentness.service.localization;

import org.fluentness.service.Service;

public interface LocalizationService extends Service {

    String translate(String key);

}