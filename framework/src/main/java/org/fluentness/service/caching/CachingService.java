package org.fluentness.service.caching;

import org.fluentness.service.Service;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.InvocationTargetException;

public interface CachingService extends Service {

    String cache(HttpServletRequest request, WebViewProvider inMissCase) throws InvocationTargetException, IllegalAccessException;
}
