package org.fluentness.service.server;

import org.apache.catalina.Context;
import org.apache.catalina.LifecycleException;
import org.apache.catalina.startup.Tomcat;
import org.fluentness.service.configuration.ConfigurationService;
import org.fluentness.service.logger.LogLevel;
import org.fluentness.service.logger.LoggerService;
import org.fluentness.service.router.RouterService;

import java.io.File;
import java.util.Arrays;
import java.util.logging.Handler;
import java.util.logging.LogRecord;

public class TomcatServerService implements ServerService {

    private ConfigurationService configuration;
    private LoggerService logger;
    private RouterService routerService;

    public TomcatServerService(ConfigurationService configuration, LoggerService logger, RouterService routerService) {
        this.configuration = configuration;
        this.logger = logger;
        this.routerService = routerService;
    }

    private Tomcat server;

    @Override
    public void start() throws LifecycleException {
        String context = configuration.has("server_context") ? configuration.get("server_context") : "";
        int port = configuration.has("server_port") ? Integer.parseInt(configuration.get("server_port")) : 8000;

        // init server
        server = new Tomcat();
        server.setPort(port);
        server.getHost().setAppBase(".");
        Context ctx = server.addContext(context, new File(".").getAbsolutePath());
        Tomcat.addServlet(ctx, "Fluentness", new DispatcherServlet(logger,routerService));
        ctx.addServletMappingDecoded("/*", "Fluentness");

        // redirect logging to own logger
        java.util.logging.Logger tomcatLogger = java.util.logging.Logger.getLogger("");
        Arrays.stream(tomcatLogger.getHandlers()).forEach(tomcatLogger::removeHandler);
        tomcatLogger.addHandler(new Handler() {
            @Override
            public void publish(LogRecord logRecord) {
                logger.log(LogLevel.fromJulLevel(logRecord.getLevel()), logRecord.getMessage());
            }

            @Override
            public void flush() {

            }

            @Override
            public void close() throws SecurityException {

            }
        });

        // start server
        server.start();
        logger.info("Tomcat Server is listening, visit http://%s:%s/", server.getServer().getAddress(), port);
        new Thread(() -> server.getServer().await()).start();
    }

    @Override
    public void stop() {
        if (server != null) {
            try {
                server.stop();
            } catch (LifecycleException e) {
                logger.error(e);
            }
        } else {
            logger.info("Server was stopped without being started");
        }
    }
}
