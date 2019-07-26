package org.fluentness.base.common.environment;

import org.fluentness.base.Base;
import org.fluentness.base.service.cacher.Cacher;
import org.fluentness.base.service.cacher.DefaultCacher;
import org.fluentness.base.service.logger.DefaultLogger;
import org.fluentness.base.service.logger.Logger;
import org.fluentness.base.service.server.DefaultServer;
import org.fluentness.base.service.server.Server;
import org.fluentness.data.Data;
import org.fluentness.flow.Flow;

import java.util.HashMap;
import java.util.Map;

import static org.fluentness.base.common.environment.BooleanKey.*;
import static org.fluentness.base.common.environment.IntegerKey.APP_PORT;
import static org.fluentness.base.common.environment.StringKey.*;

public abstract class Environment {

    private Map<Key, Object> settings = new HashMap<>();

    public Environment() {
        set(APP_PROTOCOL, "http");
        set(APP_HOST, "localhost");
        set(APP_PORT, 8000);
        set(LOG_LEVEL, "ALL");
        set(ENABLE_LOG_TO_CONSOLE, true);
        set(ENABLE_LOG_TO_FILE, false);
        set(ENABLE_CACHE, true);
        set(ENABLE_STYLE_MINIFY, true);
    }

    public <T> boolean has(Key<T> key) {
        return settings.containsKey(key);
    }

    public <T> T get(Key<T> key) {
        return (T) settings.get(key);
    }

    protected <T> void set(Key<T> key, T value) {
        settings.put(key, value);
    }

    protected void define(Base base) {
        base.set(Logger.class, DefaultLogger.class);
        base.set(Server.class, DefaultServer.class);
        base.set(Cacher.class, DefaultCacher.class);
    }

    protected void define(Data data) {

    }

    protected void define(Flow flow);

}