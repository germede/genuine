package org.fluentness.cache;

import org.fluentness.ApplicationComponent;
import org.fluentness.server.Request;

import java.lang.reflect.InvocationTargetException;

public interface Cache extends ApplicationComponent {

    String cache(Request request, Object inMissCase) throws InvocationTargetException, IllegalAccessException;
}
