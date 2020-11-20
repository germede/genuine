package org.fluentness.service.injector;

import org.fluentness.Application;
import org.fluentness.service.Service;

// All possible injectors rely on reflection for automatically instantiating the dependencies an application depends on
// If reflection isn't wished (e.g. native-image), one can directly instantiate the application and dependencies instead
public interface Injector extends Service {

    Application inject(Class<? extends Application> applicationClass) throws InjectorException;
}
