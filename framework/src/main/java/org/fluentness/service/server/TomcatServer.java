package org.fluentness.service.server;

import org.apache.catalina.Context;
import org.apache.catalina.LifecycleException;
import org.apache.catalina.startup.Tomcat;
import org.fluentness.service.configurator.Configurator;
import org.fluentness.service.dispatcher.Dispatcher;
import org.fluentness.service.injector.Injector;
import org.fluentness.service.logger.Logger;

import java.io.File;
import java.util.Arrays;

public class TomcatServer implements Server {

    private final Injector injector;
    private final Configurator configurator;
    private final Logger logger;
    private final Dispatcher dispatcher;

    private final Tomcat server;

    public TomcatServer(Injector injector, Configurator configurator, Logger logger, Dispatcher dispatcher) {
        this.injector = injector;
        this.configurator = configurator;
        this.logger = logger;
        this.dispatcher = dispatcher;

        String context = configurator.getOrDefault(server_context, "");
        int port = configurator.getOrDefault(server_port, 8000);

        // init server
        server = new Tomcat();
        server.setPort(port);
        server.getHost().setAppBase(".");
        Context ctx = server.addContext(context, new File(".").getAbsolutePath());
        Tomcat.addServlet(ctx, "Fluentness", dispatcher);
        ctx.addServletMappingDecoded("/*", "Fluentness");

        // redirect logging to own logger
        java.util.logging.Logger tomcatLogger = java.util.logging.Logger.getLogger("");
        Arrays.stream(tomcatLogger.getHandlers()).forEach(tomcatLogger::removeHandler);
        tomcatLogger.addHandler(new TomcatLoggingBridge(logger));
    }

    @Override
    public void start() throws ServerException {
        try {
            server.start();
            logger.info(
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
                logger.error(e);
            }
        } else {
            logger.warning("Server was stopped without being started");
        }
    }
}
