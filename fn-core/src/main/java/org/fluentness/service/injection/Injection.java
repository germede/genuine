package org.fluentness.service.injection;

import org.fluentness.Application;
import org.fluentness.ApplicationComponent;
import org.fluentness.service.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface Injection extends Service {

    void inject(Application application) throws InjectionException;

}
