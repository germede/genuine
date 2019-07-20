package org.fluentness.base.server;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public enum HttpRequestRegister {
    instance;

    private Map<Thread, HttpRequest> requests = new HashMap<>();

    public void putCurrent(HttpRequest request) {
        requests.put(Thread.currentThread(), request);
    }

    public HttpRequest getCurrent() {
        return requests.get(Thread.currentThread());
    }

    public void removeCurrent() {
        requests.remove(Thread.currentThread());
    }

    public Locale getCurrentLocale() {
        HttpRequest httpRequest = getCurrent();
        return httpRequest != null ?
            httpRequest.getPreferredLocale() :
            Locale.getDefault();
    }
}
