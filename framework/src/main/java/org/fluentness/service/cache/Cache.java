package org.fluentness.service.cache;

import org.fluentness.service.Service;
import org.fluentness.service.Singleton;
import org.fluentness.service.server.Request;

import java.lang.reflect.InvocationTargetException;

@Singleton
public interface Cache extends Service {

    String cache(Request request, Object inMissCase) throws InvocationTargetException, IllegalAccessException;
}
