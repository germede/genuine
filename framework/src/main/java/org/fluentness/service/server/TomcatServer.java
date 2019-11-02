package org.fluentness.service.server;

import org.apache.catalina.Context;
import org.apache.catalina.LifecycleException;
import org.apache.catalina.startup.Tomcat;
import org.fluentness.service.configuration.Configuration;
import org.fluentness.service.logger.Logger;

import java.io.File;

public class TomcatServer implements Server {

    private Configuration configuration;
    private Logger logger;
    private DispatcherServlet dispatcherServlet;

    public TomcatServer(Configuration configuration,
                        Logger logger,
                        DispatcherServlet dispatcherServlet) {
        this.configuration = configuration;
        this.logger = logger;
        this.dispatcherServlet = dispatcherServlet;
    }

    private Tomcat server;

    @Override
    public void start() throws LifecycleException {
        String context = configuration.has("server_context") ? configuration.get("server_context"): "";
        int port = configuration.has("server_port") ? Integer.parseInt(configuration.get("server_port")) : 8000;
        server = new Tomcat();
        server.setPort(port);
        server.getHost().setAppBase(".");
        Context ctx = server.addContext(context, new File(".").getAbsolutePath());
        Tomcat.addServlet(ctx, "Fluentness", dispatcherServlet);
        ctx.addServletMappingDecoded("/*", "Fluentness");
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
