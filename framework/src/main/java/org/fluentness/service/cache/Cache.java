package org.fluentness.service.cache;

import org.fluentness.service.Service;
import org.fluentness.service.Singleton;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.InvocationTargetException;

@Singleton
public interface Cache extends Service {

    String cache(HttpServletRequest request, WebViewProvider inMissCase) throws InvocationTargetException, IllegalAccessException;
}
