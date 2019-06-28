package org.fluentness.base.networking;

import org.fluentness.base.generics.Register;

import java.util.Locale;

public enum HttpRequestRegister implements Register<HttpRequestRegister, Thread, HttpRequest> {
    call;

    public void putCurrent(HttpRequest request) {
        put(Thread.currentThread(),request);
    }

    public HttpRequest getCurrent() {
        return get(Thread.currentThread());
    }

    public void removeCurrent() {
        remove(Thread.currentThread());
    }

    public static Locale getCurrentLocale() {
        HttpRequest httpRequest = call.getCurrent();
        return httpRequest != null ?
            httpRequest.getPreferredLocale() :
            Locale.getDefault();
    }
}
