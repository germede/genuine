package org.fluentness.service.injector;

import org.fluentness.ApplicationComponent;
import org.fluentness.service.Service;

import java.util.List;

import static org.fluentness.service.Service.ServiceType;
import static org.fluentness.service.Service.Type.IRREPLACEABLE;

@ServiceType(IRREPLACEABLE)
public interface Injector extends Service {

    <A extends ApplicationComponent> List<A> getInstances(Class<A> parent);

    <A extends ApplicationComponent> A getInstance(Class<A> parent);
}
