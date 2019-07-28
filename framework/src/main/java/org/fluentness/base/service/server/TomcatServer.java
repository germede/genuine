package org.fluentness.base.service.server;

import org.apache.catalina.Context;
import org.apache.catalina.LifecycleException;
import org.apache.catalina.startup.Tomcat;
import org.fluentness.base.common.annotation.Inject;
import org.fluentness.base.common.exception.DefinitionException;
import org.fluentness.base.service.logger.Logger;
import org.fluentness.base.service.configuration.Configuration;

import java.io.File;
import java.util.Map;

import static org.fluentness.base.service.configuration.Configuration.APP_PORT;
import static org.fluentness.base.service.configuration.Configuration.APP_HOSTNAME;

public class TomcatServer implements Server {

    @Inject
    Configuration configuration;

    @Inject
    Logger logger;

    private final String hostname;
    private final int port;

    private final Tomcat tomcat;

    public TomcatServer(@Dependency ) throws DefinitionException {
        hostname = configuration.get(APP_HOSTNAME);
        port = configuration.get(APP_PORT);

        tomcat = new Tomcat();
        tomcat.setPort(port);
        tomcat.getHost().setAppBase(".");
    }

    @Override
    public void start(Map<String, HttpHandler> routing) {
        try {
            Context ctx = tomcat.addContext("/", new File(".").getAbsolutePath());
            Tomcat.addServlet(ctx, "Fluentness", new FluentnessServlet(routing));
            ctx.addServletMappingDecoded("/*", "Fluentness");

            tomcat.start();
            logger.info("Tomcat Server is listening, visit http://%s:%s/", hostname, port);
            tomcat.getServer().await();
        } catch (Exception e) {
            logger.error(e);
            e.printStackTrace();
        }
    }

    @Override
    public void stop() {
        try {
            tomcat.stop();
        } catch (LifecycleException e) {
            logger.error(e);
        }
    }
}
