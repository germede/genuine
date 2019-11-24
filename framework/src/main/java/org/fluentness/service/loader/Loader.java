package org.fluentness.service.loader;

import org.fluentness.ApplicationComponent;
import org.fluentness.service.Service;

import java.util.List;

import static org.fluentness.service.Service.ServiceType;
import static org.fluentness.service.Service.Type.IRREPLACEABLE;

@ServiceType(IRREPLACEABLE)
public interface Loader extends Service {

    <A extends ApplicationComponent> List<Class<? extends A>> load(String packageName, Class<A> parent) throws LoaderException;
}
