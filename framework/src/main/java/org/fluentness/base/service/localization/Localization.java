package org.fluentness.base.service.localization;

import org.fluentness.base.service.Service;

public interface Localization extends Service {

    <T> boolean has(Setting<T> key);

    <T> T get(Setting<T> key);
}