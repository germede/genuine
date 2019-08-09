package org.fluentness.base.service.localization;

public interface Localization extends Service {

    <T> boolean has(Setting<T> key);

    <T> T get(Setting<T> key);
}