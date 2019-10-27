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

    private String hostname;
    private int port;
    private Tomcat server;

    public TomcatServerService(ConfigurationService configurationService, LoggerService loggerService) throws Exception {
        this.configurationService = configurationService;
        this.loggerService = loggerService;

        hostname = configurationService.get("app_host");
        port = Integer.parseInt(configurationService.get("app_port"));

        server = new Tomcat();
        server.setPort(port);
        server.getHost().setAppBase(".");
    }

    @Override
    public void start(Map<String, HttpHandler> routing) {
        try {
            Context ctx = server.addContext("/", new File(".").getAbsolutePath());
            Tomcat.addServlet(ctx, "Fluentness", new HttpServlet(loggerService, routing));
            ctx.addServletMappingDecoded("/*", "Fluentness");

            server.start();
            loggerService.info("Tomcat Server is listening, visit http://%s:%s/", hostname, port);
            server.getServer().await();
        } catch (Exception e) {
            loggerService.error(e);
            e.printStackTrace();
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
