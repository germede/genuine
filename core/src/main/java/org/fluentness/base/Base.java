package org.fluentness.base;

import org.fluentness.base.cacher.Cacher;
import org.fluentness.base.cacher.DefaultCacher;
import org.fluentness.base.config.Config;
import org.fluentness.base.config.DefaultConfig;
import org.fluentness.base.logger.Logger;
import org.fluentness.base.logger.DefaultLogger;
import org.fluentness.base.server.Router;
import org.fluentness.base.server.Server;
import org.fluentness.base.server.DefaultServer;
import org.fluentness.base.server.StaticResourceHandler;

public class Base {

    private Config config = new DefaultConfig();
    private Logger logger = new DefaultLogger(java.util.logging.Logger.getGlobal());
    private Server server = new DefaultServer(new Router(new StaticResourceHandler()));
    private Cacher cacher = new DefaultCacher();

    public void initialize() {
        getConfig().initialize();
        getLogger().initialize();
        getServer().initialize();
        getCacher().initialize();
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
