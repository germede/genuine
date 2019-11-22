package org.fluentness.service.server;

import org.apache.catalina.Context;
import org.apache.catalina.LifecycleException;
import org.apache.catalina.startup.Tomcat;
import org.fluentness.service.configurator.Configurator;
import org.fluentness.service.logger.Logger;
import org.fluentness.service.router.Router;

import java.io.File;
import java.util.Arrays;

import static org.fluentness.service.configurator.Configurator.server_context;
import static org.fluentness.service.configurator.Configurator.server_port;

public class TomcatServer implements Server {

    private final Configurator configurator;
    private final Logger logger;
    private final Router router;

    private final Tomcat server;

    public TomcatServer(Configurator configurator,
                        Logger logger,
                        Router router) {
        this.configurator = configurator;
        this.logger = logger;
        this.router = router;

        String context = configurator.getOrDefault(server_context, "");
        int port = configurator.getOrDefault(server_port, 8000);

        // init server
        server = new Tomcat();
        server.setPort(port);
        server.getHost().setAppBase(".");
        Context ctx = server.addContext(context, new File(".").getAbsolutePath());
        Tomcat.addServlet(ctx, "Fluentness", new DispatcherServlet(logger, router));
        ctx.addServletMappingDecoded("/*", "Fluentness");

        // redirect logging to own logger
        java.util.logging.Logger tomcatLogger = java.util.logging.Logger.getLogger("");
        Arrays.stream(tomcatLogger.getHandlers()).forEach(tomcatLogger::removeHandler);
        tomcatLogger.addHandler(new TomcatLoggingBridge(logger));
    }

    @Override
    public void start() throws ServingException {
        try {
            server.start();
            logger.info(
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
                logger.error(e);
            }
        } else {
            logger.info("Server was stopped without being started");
        }
    }
}
