package org.fluentness.service.cache;

import org.fluentness.service.logger.Logger;
import org.fluentness.service.server.Request;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

public class MemoryCache implements Cache {

    private final Logger logger;

    private final Map<String, String> cache = new HashMap<>();

    public MemoryCache(Logger logger) {
        this.logger = logger;
    }

    @Override
    public String cache(Request request, WebViewProvider inMissCase) throws InvocationTargetException, IllegalAccessException {

        String hash = request.getMethod() + " " + request.getUri();
        if (cache.containsKey(hash)) {
            logger.debug("Cache hit for %s", hash);
            return cache.get(hash);
        }

        String render = inMissCase.provide().render();
        cache.put(hash, render);
        logger.debug("Cache miss for %s", hash);
        return render;
    }

}
