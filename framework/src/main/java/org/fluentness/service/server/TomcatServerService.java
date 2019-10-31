package org.fluentness.service.server;

import org.apache.catalina.Context;
import org.apache.catalina.LifecycleException;
import org.apache.catalina.startup.Tomcat;
import org.fluentness.service.configuration.ConfigurationService;
import org.fluentness.service.logger.LoggerService;

import java.io.File;
import java.util.Map;

public class TomcatServerService implements ServerService {

    private ConfigurationService configurationService;
    private LoggerService loggerService;
    private HttpServlet httpServlet;

    private String hostname;
    private int port;
    private Tomcat server;

    public TomcatServerService(ConfigurationService configurationService, LoggerService loggerService, HttpServlet httpServlet) {
        this.configurationService = configurationService;
        this.loggerService = loggerService;
        this.httpServlet = httpServlet;
    }


    @Override
    public void prepare(Map<String, HttpHandler> routing) {
        hostname = configurationService.get("app_host");
        port = Integer.parseInt(configurationService.get("app_port"));
        server = new Tomcat();
        server.setPort(port);
        server.getHost().setAppBase(".");
        httpServlet.setRouting(routing);
        Context ctx = server.addContext("/", new File(".").getAbsolutePath());
        Tomcat.addServlet(ctx, "Fluentness", httpServlet);
        ctx.addServletMappingDecoded("/*", "Fluentness");
    }

    @Override
    public void start() {
        try {
            server.start();
            loggerService.info("Tomcat Server is listening, visit http://%s:%s/", hostname, port);
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
