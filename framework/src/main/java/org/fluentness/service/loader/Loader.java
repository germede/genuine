package org.fluentness.service.loader;

import org.fluentness.ApplicationComponent;
import org.fluentness.service.Service;

import java.util.List;

public interface Loader extends Service {

    <A extends ApplicationComponent> List<Class<? extends A>> load(String packageName, Class<A> parent) throws LoaderException;
}
