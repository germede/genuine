package org.fluentness.service.server;

import org.apache.catalina.Context;
import org.apache.catalina.LifecycleException;
import org.apache.catalina.startup.Tomcat;
import org.fluentness.service.configuration.Configuration;
import org.fluentness.service.log.Log;
import org.fluentness.service.log.LogLevel;
import org.fluentness.service.servlet.Servlet;

import java.io.File;
import java.util.Arrays;
import java.util.logging.Handler;
import java.util.logging.LogRecord;

public class TomcatServer extends Handler implements Server {

    private final Log log;

    private final Tomcat server;

    public TomcatServer(Configuration configuration, Log log, Servlet[] servlets) {
        this.log = log;

        server = new Tomcat();
        server.setPort(configuration.get(PORT));
        server.getHost().setAppBase(".");

        Context ctx = server.addContext(configuration.get(CONTEXT), new File(".").getAbsolutePath());
        for (Servlet servlet : servlets) {
            Tomcat.addServlet(ctx, servlet.getClass().getSimpleName(), servlet);
            ctx.addServletMappingDecoded("/static", servlet.getClass().getSimpleName());
        }

        java.util.logging.Logger tomcatLogger = java.util.logging.Logger.getLogger("");
        Arrays.stream(tomcatLogger.getHandlers()).forEach(tomcatLogger::removeHandler);
        tomcatLogger.addHandler(this);
    }

    @Override
    public void start() throws LifecycleException {
        server.start();
        log.info(
            "Tomcat Server is listening, visit http://%s:%s/",
            server.getHost().getName(),
            server.getConnector().getPort()
        );
        new Thread(() -> server.getServer().await()).start();
    }

    @Override
    public void stop() {
        if (server != null) {
            try {
                server.stop();
            } catch (LifecycleException e) {
                log.error(e);
            }
        } else {
            log.warning("Server was stopped without being started");
        }
    }

    @Override
    public void publish(LogRecord record) {
        log.log(LogLevel.fromJulLevel(record.getLevel()), record.getMessage());
    }

    @Override
    public void flush() {

    }

    @Override
    public void close() throws SecurityException {

    }
}
