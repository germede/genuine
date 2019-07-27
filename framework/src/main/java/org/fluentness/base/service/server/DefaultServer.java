package org.fluentness.base.service.server;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import org.apache.catalina.Context;
import org.apache.catalina.LifecycleException;
import org.apache.catalina.startup.Tomcat;
import org.fluentness.base.common.exception.DefinitionException;
import org.fluentness.base.service.config.Config;
import org.fluentness.base.service.logger.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.Writer;
import java.util.Map;

import static org.fluentness.base.service.config.IntegerKey.APP_PORT;
import static org.fluentness.base.service.config.StringKey.APP_HOSTNAME;

public class DefaultServer implements Server {

    private final String hostname;
    private final int port;
    private final Tomcat tomcat;

    public DefaultServer() throws DefinitionException {

        hostname = service(Config.class).get(APP_HOSTNAME);
        port = service(Config.class).get(APP_PORT);


        tomcat = new Tomcat();
        tomcat.setPort(port);

        Context ctx = tomcat.addContext("/", new File(".").getAbsolutePath());

        Tomcat.addServlet(ctx, "Fluentness", new HttpServlet() {
            @Override
            protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
                super.doGet(req, resp);
            }

            @Override
            protected void service(HttpServletRequest req, HttpServletResponse resp)
                throws ServletException, IOException {

                Writer w = resp.getWriter();
                w.write("Embedded Tomcat servlet.\n");
                w.flush();
                w.close();
            }
        });

        ctx.addServletMappingDecoded("/*", "Fluentness");



    }

    @Override
    public void start(Map<String, HttpHandler> routeHandlerMap) {
        try {
            tomcat.start();
            tomcat.getServer().await();
            service(Logger.class).debug("Server is listening. Visit http://" + hostname + ":" + port + "/");
        } catch (LifecycleException e) {
            service(Logger.class).fatal(e);
        }
    }

    @Override
    public void serve(HttpExchange httpExchange, HttpResponse httpResponse) {

    }

    @Override
    public void stop() {
        try {
            tomcat.stop();
        } catch (LifecycleException e) {
            service(Logger.class).fatal(e);
        }
    }
}
