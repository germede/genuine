package org.fluentness.service.injector;

import org.fluentness.ApplicationComponent;

import java.util.List;

public interface Injector extends ApplicationComponent {

    <A extends ApplicationComponent> List<A> getInstances(Class<A> parent);

    <A extends ApplicationComponent> A getInstance(Class<A> parent);
}
