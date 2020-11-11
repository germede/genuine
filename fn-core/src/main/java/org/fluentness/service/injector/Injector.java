package org.fluentness.service.injector;

import org.fluentness.application.Application;
import org.fluentness.service.Service;

public interface Injector extends Service {

    Application inject(Class<? extends Application> applicationClass) throws InjectorException;
}
