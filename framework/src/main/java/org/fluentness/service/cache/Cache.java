package org.fluentness.service.cache;

import org.fluentness.service.Service;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.InvocationTargetException;

import static org.fluentness.service.Service.ServiceType;
import static org.fluentness.service.Service.Type.REPLACEABLE;

@ServiceType(REPLACEABLE)
public interface Cache extends Service {

    String cache(HttpServletRequest request, WebViewProvider inMissCase) throws InvocationTargetException, IllegalAccessException;
}
