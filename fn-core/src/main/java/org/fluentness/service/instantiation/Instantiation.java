package org.fluentness.service.instantiation;

import org.fluentness.application.Application;
import org.fluentness.service.Service;

public interface Instantiation extends Service {

    Application instantiate(Class<? extends Application> applicationClass) throws InstantiationException;
}
