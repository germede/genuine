package org.fluentness.service.serving;

import org.apache.catalina.Context;
import org.apache.catalina.LifecycleException;
import org.apache.catalina.startup.Tomcat;
import org.fluentness.service.configuration.ConfigurationService;
import org.fluentness.service.logging.LoggingService;
import org.fluentness.service.routing.RoutingService;

import java.io.File;
import java.util.Arrays;

import static org.fluentness.service.configuration.ConfigurationService.server_context;
import static org.fluentness.service.configuration.ConfigurationService.server_port;

public class TomcatServingService implements ServingService {

    private final ConfigurationService configurationService;
    private final LoggingService loggingService;
    private final RoutingService routingService;

    private final Tomcat server;

    public TomcatServingService(ConfigurationService configurationService,
                                LoggingService loggingService,
                                RoutingService routingService) {
        this.configurationService = configurationService;
        this.loggingService = loggingService;
        this.routingService = routingService;

        String context = configurationService.has(server_context) ? configurationService.get(server_context) : "";
        int port = configurationService.has(server_port) ? configurationService.get(server_port) : 8000;

        // init server
        server = new Tomcat();
        server.setPort(port);
        server.getHost().setAppBase(".");
        Context ctx = server.addContext(context, new File(".").getAbsolutePath());
        Tomcat.addServlet(ctx, "Fluentness", new DispatcherServlet(loggingService, routingService));
        ctx.addServletMappingDecoded("/*", "Fluentness");

        // redirect logging to own logger
        java.util.logging.Logger tomcatLogger = java.util.logging.Logger.getLogger("");
        Arrays.stream(tomcatLogger.getHandlers()).forEach(tomcatLogger::removeHandler);
        tomcatLogger.addHandler(new TomcatLoggingBridge(loggingService));
    }

    @Override
    public void start() throws ServingException {
        try {
            server.start();
            loggingService.info(
                "Tomcat Server is listening, visit http://%s:%s/",
                server.getHost().getName(),
                server.getConnector().getPort()
            );
            new Thread(() -> server.getServer().await()).start();
        } catch (LifecycleException e) {
            throw new ServingException(e);
        }
    }

    @Override
    public void stop() {
        if (server != null) {
            try {
                server.stop();
            } catch (LifecycleException e) {
                loggingService.error(e);
            }
        } else {
            loggingService.info("Server was stopped without being started");
        }
    }
}
