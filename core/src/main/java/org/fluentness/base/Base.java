package org.fluentness.base;

import org.fluentness.base.cacher.Cacher;
import org.fluentness.base.cacher.DefaultCacher;
import org.fluentness.base.config.Config;
import org.fluentness.base.config.DefaultConfig;
import org.fluentness.base.logger.DefaultLogger;
import org.fluentness.base.logger.Logger;
import org.fluentness.base.server.DefaultServer;
import org.fluentness.base.server.Router;
import org.fluentness.base.server.Server;
import org.fluentness.base.server.StaticResourceHandler;

public class Base {

    private Config config;
    private Logger logger;
    private Server server;
    private Cacher cacher;

    public void initialize() {
        if (config == null) {
            config = new DefaultConfig();
            config.initialize();
        }
        if (logger == null) {
            logger = new DefaultLogger(
                java.util.logging.Logger.getLogger(String.valueOf(System.currentTimeMillis())) // always get a new logger
            );
        }

        logger.initialize();
        if (server == null) {
            server = new DefaultServer(new Router(new StaticResourceHandler()));
            server.initialize();
        }
        if (cacher == null) {
            cacher = new DefaultCacher();
            cacher.initialize();
        }
    }

    public void reset() {
        config = null;
        logger = null;
        server = null;
        cacher = null;
    }

    public Config getConfig() {
        return config;
    }

    public void setConfig(Config config) {
        this.config = config;
    }

    public Logger getLogger() {
        return logger;
    }

    public void setLogger(Logger logger) {
        this.logger = logger;
    }

    public Server getServer() {
        return server;
    }

    public void setServer(Server server) {
        this.server = server;
    }

    public Cacher getCacher() {
        return cacher;
    }

    public void setCacher(Cacher cacher) {
        this.cacher = cacher;
    }
}
