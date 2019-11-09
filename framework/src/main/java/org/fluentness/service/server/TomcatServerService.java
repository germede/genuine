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

import static org.fluentness.service.configuration.ConfigurationService.server_context;
import static org.fluentness.service.configuration.ConfigurationService.server_port;

public class TomcatServerService implements ServerService {

    private final ConfigurationService configurationService;
    private final LoggerService loggerService;
    private final RouterService routerService;

    private final Tomcat server;

    public TomcatServerService(ConfigurationService configurationService, LoggerService loggerService, RouterService routerService) {
        this.configurationService = configurationService;
        this.loggerService = loggerService;
        this.routerService = routerService;

        String context = configurationService.has(server_context) ? configurationService.get(server_context) : "";
        int port = configurationService.has(server_port) ? configurationService.get(server_port) : 8000;

        // init server
        server = new Tomcat();
        server.setPort(port);
        server.getHost().setAppBase(".");
        Context ctx = server.addContext(context, new File(".").getAbsolutePath());
        Tomcat.addServlet(ctx, "Fluentness", new DispatcherServlet(loggerService, routerService));
        ctx.addServletMappingDecoded("/*", "Fluentness");

        // redirect logging to own logger
        java.util.logging.Logger tomcatLogger = java.util.logging.Logger.getLogger("");
        Arrays.stream(tomcatLogger.getHandlers()).forEach(tomcatLogger::removeHandler);
        tomcatLogger.addHandler(new Handler() {
            @Override
            public void publish(LogRecord logRecord) {
                loggerService.log(LogLevel.fromJulLevel(logRecord.getLevel()), logRecord.getMessage());
            }

            @Override
            public void flush() {
            }

            @Override
            public void close() throws SecurityException {
            }
        });
    }

    @Override
    public void start() throws ServerException {
        try {
            server.start();
            loggerService.info(
                "Tomcat Server is listening, visit http://%s:%s/",
                server.getHost().getName(),
                server.getConnector().getPort()
            );
            new Thread(() -> server.getServer().await()).start();
        } catch (LifecycleException e) {
            throw new ServerException(e);
        }
    }

    @Override
    public void stop() {
        if (server != null) {
            try {
                server.stop();
            } catch (LifecycleException e) {
                loggerService.error(e);
            }
        } else {
            loggerService.info("Server was stopped without being started");
        }
    }
}
