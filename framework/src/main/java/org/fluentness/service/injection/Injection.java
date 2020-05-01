package org.fluentness.service.injection;

import org.fluentness.Application;
import org.fluentness.service.Service;

import java.util.Map;

public interface Injection extends Service {

    Map<Class, Object> inject(Application application) throws InjectionException;

}
