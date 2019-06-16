package org.fluentness.common.networking;

import org.fluentness.common.generics.Register;

public enum HttpRequestRegister implements Register<Thread, HttpRequest> {
    INSTANCE;

    public void putCurrent(HttpRequest request) {
        put(Thread.currentThread(),request);
    }

    public HttpRequest getCurrent() {
        return get(Thread.currentThread());
    }

    public void removeCurrent() {
        remove(Thread.currentThread());
    }
}
