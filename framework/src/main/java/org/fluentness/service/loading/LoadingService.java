package org.fluentness.service.loading;

import org.fluentness.ApplicationComponent;
import org.fluentness.service.Service;

import java.util.List;

public interface LoadingService extends Service {

    <A extends ApplicationComponent> List<Class<? extends A>> load(String packageName, Class<A> parent) throws LoadingException;
}
