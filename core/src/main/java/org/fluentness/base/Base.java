package org.fluentness.base;

import org.fluentness.base.cacher.Cacher;
import org.fluentness.base.cacher.CacherImpl;
import org.fluentness.base.config.Config;
import org.fluentness.base.config.ConfigImpl;
import org.fluentness.base.logger.Logger;
import org.fluentness.base.logger.LoggerImpl;
import org.fluentness.base.server.Router;
import org.fluentness.base.server.Server;
import org.fluentness.base.server.ServerImpl;
import org.fluentness.base.server.StaticResourceHandler;

public class Base {

    private Config config = new ConfigImpl();
    private Logger logger = new LoggerImpl(java.util.logging.Logger.getGlobal());
    private Server server = new ServerImpl(new Router(new StaticResourceHandler()));
    private Cacher cacher = new CacherImpl();

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
