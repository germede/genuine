package org.fluentness.configuration;

import org.fluentness.ApplicationComponent;

public interface Configuration extends ApplicationComponent {

    <T> boolean has(Key<T> key);

    <T> T get(Key<T> key);

}