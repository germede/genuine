package org.fluentness.service.injection;

import org.fluentness.service.Service;

public interface Injection extends Service {

    void inject() throws InjectionException;

}
