package org.fluentness.service.cache;

import org.fluentness.ApplicationComponent;
import org.fluentness.service.server.Request;

import java.lang.reflect.InvocationTargetException;

public interface Cache extends ApplicationComponent {

    String cache(Request request, Object inMissCase) throws InvocationTargetException, IllegalAccessException;
}
