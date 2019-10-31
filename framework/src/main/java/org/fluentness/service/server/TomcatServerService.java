package org.fluentness.service.server;

import org.apache.catalina.Context;
import org.apache.catalina.LifecycleException;
import org.apache.catalina.startup.Tomcat;
import org.fluentness.service.configuration.ConfigurationService;
import org.fluentness.service.logger.LoggerService;
import org.fluentness.service.routing.RoutingService;

import java.io.File;

public class TomcatServerService implements ServerService {

    private ConfigurationService configurationService;
    private LoggerService loggerService;
    private RoutingService routingService;
    private HttpServlet httpServlet;

    private String host;
    private int port;
    private Tomcat server;

    public TomcatServerService(ConfigurationService configurationService, LoggerService loggerService, RoutingService routingService, HttpServlet httpServlet) {
        this.configurationService = configurationService;
        this.loggerService = loggerService;
        this.routingService = routingService;
        this.httpServlet = httpServlet;
        prepare();
    }

    private void prepare() {
        host = configurationService.get("app_host");
        port = Integer.parseInt(configurationService.get("app_port"));
        server = new Tomcat();
        server.setPort(port);
        server.getHost().setAppBase(".");
        Context ctx = server.addContext("/", new File(".").getAbsolutePath());
        Tomcat.addServlet(ctx, "Fluentness", httpServlet);
        ctx.addServletMappingDecoded("/*", "Fluentness");
    }

    @Override
    public void start() {
        httpServlet.setRouting(routingService.getRoutingMap());
        try {
            server.start();
            loggerService.info("Tomcat Server is listening, visit http://%s:%s/", host, port);
            server.getServer().await();
        } catch (Exception e) {
            loggerService.error(e);
        }
    }

    @Override
    public void stop() {
        try {
            server.stop();
        } catch (LifecycleException e) {
            loggerService.error(e);
        }
    }
}
