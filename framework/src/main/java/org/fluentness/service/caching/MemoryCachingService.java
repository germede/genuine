package org.fluentness.service.caching;

import org.fluentness.service.logging.LoggingService;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

public class MemoryCachingService implements CachingService {

    private final LoggingService loggingService;

    private final Map<String, String> cache = new HashMap<>();

    public MemoryCachingService(LoggingService loggingService) {
        this.loggingService = loggingService;
    }

    @Override
    public String cache(HttpServletRequest request, WebViewProvider inMissCase) throws InvocationTargetException, IllegalAccessException {

        String query = request.getQueryString() == null ? "" : ("?" + request.getQueryString());
        String hash = request.getMethod() + " " + request.getRequestURI() + query;
        if (cache.containsKey(hash)) {
            loggingService.debug("Cache hit for %s", hash);
            return cache.get(hash);
        }

        String render = inMissCase.provide().render();
        cache.put(hash, render);
        loggingService.debug("Cache miss for %s", hash);
        return render;
    }

}
