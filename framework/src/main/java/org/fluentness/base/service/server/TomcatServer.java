package org.fluentness.base.service.server;

import org.apache.catalina.Context;
import org.apache.catalina.LifecycleException;
import org.apache.catalina.startup.Tomcat;
import org.fluentness.base.common.exception.DefinitionException;
import org.fluentness.base.service.configuration.ConfigurationService;
import org.fluentness.base.service.logger.Logger;

import java.io.File;
import java.util.Map;

import static org.fluentness.base.service.configuration.ConfigurationService.APP_HOSTNAME;
import static org.fluentness.base.service.configuration.ConfigurationService.APP_PORT;

public class TomcatServer implements Server {

    private ConfigurationService configurationService;
    private Logger logger;

    private String hostname;
    private int port;
    private Tomcat server;

    public TomcatServer(ConfigurationService configurationService, Logger logger) throws DefinitionException {
        this.configurationService = configurationService;
        this.logger = logger;

        init();
    }

    private void init() {
        hostname = configurationService.get(APP_HOSTNAME);
        port = configurationService.get(APP_PORT);

        server = new Tomcat();
        server.setPort(port);
        server.getHost().setAppBase(".");
    }

    @Override
    public void start(Map<String, HttpHandler> routing) {
        try {
            Context ctx = server.addContext("/", new File(".").getAbsolutePath());
            Tomcat.addServlet(ctx, "Fluentness", new HttpServlet(routing));
            ctx.addServletMappingDecoded("/*", "Fluentness");

            server.start();
            logger.info("Tomcat Server is listening, visit http://%s:%s/", hostname, port);
            server.getServer().await();
        } catch (Exception e) {
            logger.error(e);
            e.printStackTrace();
        }
    }

    @Override
    public void stop() {
        try {
            server.stop();
        } catch (LifecycleException e) {
            logger.error(e);
        }
    }
}
