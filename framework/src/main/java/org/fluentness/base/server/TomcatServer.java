package org.fluentness.base.server;

import org.apache.catalina.Context;
import org.apache.catalina.LifecycleException;
import org.apache.catalina.startup.Tomcat;
import org.fluentness.base.exception.DefinitionException;
import org.fluentness.base.configuration.Configuration;
import org.fluentness.base.logger.Logger;

import java.io.File;
import java.util.Map;

public class TomcatServer implements Server {

    private Configuration configuration;
    private Logger logger;

    private String hostname;
    private int port;
    private Tomcat server;

    public TomcatServer(Configuration configuration, Logger logger) throws DefinitionException {
        this.configuration = configuration;
        this.logger = logger;

        init();
    }

    private void init() {
        hostname = configuration.get("app_host");
        port = Integer.parseInt(configuration.get("app_port"));

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
