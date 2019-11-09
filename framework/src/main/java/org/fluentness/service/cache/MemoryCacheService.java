package org.fluentness.service.cache;

import org.fluentness.service.logger.LoggerService;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

public class MemoryCacheService implements CacheService {

    private final LoggerService loggerService;

    private final Map<String, String> cache = new HashMap<>();

    public MemoryCacheService(LoggerService loggerService) {
        this.loggerService = loggerService;
    }

    @Override
    public String cache(HttpServletRequest request, WebViewProvider inMissCase) throws InvocationTargetException, IllegalAccessException {

        String query = request.getQueryString() == null ? "" : ("?" + request.getQueryString());
        String hash = request.getMethod() + " " + request.getRequestURI() + query;
        if (cache.containsKey(hash)) {
            loggerService.debug("Cache hit for %s", hash);
            return cache.get(hash);
        }

        String render = inMissCase.provide().render();
        cache.put(hash, render);
        loggerService.debug("Cache miss for %s", hash);
        return render;
    }

}
