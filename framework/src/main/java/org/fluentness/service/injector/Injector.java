package org.fluentness.service.injector;

import org.fluentness.ApplicationComponent;
import org.fluentness.service.Service;
import org.fluentness.service.Singleton;

import java.util.List;

@Singleton
public interface Injector extends Service {

    <A extends ApplicationComponent> List<A> getInstances(Class<A> parent);

    <A extends ApplicationComponent> A getInstance(Class<A> parent);
}
