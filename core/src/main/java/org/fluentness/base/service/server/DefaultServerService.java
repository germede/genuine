package org.fluentness.base.service.server;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import fi.iki.elonen.NanoHTTPD;
import org.apache.catalina.Context;
import org.apache.catalina.startup.Tomcat;
import org.fluentness.base.common.exception.DefinitionException;
import org.fluentness.base.service.config.ConfigService;
import org.fluentness.base.service.logger.LoggerService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

import static fi.iki.elonen.NanoHTTPD.SOCKET_READ_TIMEOUT;
import static fi.iki.elonen.NanoHTTPD.newFixedLengthResponse;
import static org.fluentness.base.service.config.IntegerKey.APP_PORT;
import static org.fluentness.base.service.config.StringKey.APP_HOSTNAME;

public class DefaultServerService implements ServerService {

    private final String hostname;
    private final int port;
    private final Tomcat internalServer;

    public DefaultServerService() throws DefinitionException {

        hostname = service(ConfigService.class).get(APP_HOSTNAME);
        port = service(ConfigService.class).get(APP_PORT);


        internalServer = new Tomcat();
        internalServer.setPort(port);

        Context ctx = internalServer.addContext("/", new File(".").getAbsolutePath());

        Tomcat.addServlet(ctx, "Embedded", new HttpServlet() {
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

        ctx.addServletMapping("/*", "Embedded");

        tomcat.start();
        tomcat.getServer().await();

        internalServer = new NanoHTTPD(hostname, port) {
            @Override
            public Response serve(IHTTPSession session) {

                session.getCookies();


                return newFixedLengthResponse();
            }
        };


    }


    @Override
    public NanoHTTPD.Response serve(IHTTPSession session) {
        String msg = "<html><body><h1>Hello server</h1>\n";
        Map<String, String> parms = session.getParms();
        if (parms.get("username") == null) {
            msg += "<form action='?' method='get'>\n  <p>Your name: <input type='text' name='username'></p>\n" + "</form>\n";
        } else {
            msg += "<p>Hello, " + parms.get("username") + "!</p>";
        }
        return newFixedLengthResponse(msg + "</body></html>\n");
    }

    @Override
    public void start(Map<String, HttpHandler> routeHandlerMap) {
        try {
            internalServer.start(SOCKET_READ_TIMEOUT, false);
            service(LoggerService.class).fine("Server is listening. Visit http://" + hostname + ":" + port + "/");
        } catch (IOException e) {
            service(LoggerService.class).severe(e);
        }
    }

    @Override
    public void serve(HttpExchange httpExchange, HttpResponse httpResponse) {

    }

    @Override
    public void stop() {
        internalServer.stop();
    }
}
