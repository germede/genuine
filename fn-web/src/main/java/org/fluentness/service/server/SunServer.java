package org.fluentness.service.server;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpServer;
import org.fluentness.service.configuration.Configuration;
import org.fluentness.service.log.Log;
import org.fluentness.service.router.Router;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.net.InetSocketAddress;

public class SunServer implements Server {

    private final Configuration configuration;
    private final Router router;
    private final Log log;

    private HttpServer server;

    public SunServer(Configuration configuration, Router router, Log log) {
        this.configuration = configuration;
        this.router = router;
        this.log = log;
    }

    @Override
    public void start() throws IOException {
        server = HttpServer.create(new InetSocketAddress(configuration.get(HOST), configuration.get(PORT)), 0);
        server.createContext(configuration.get(CONTEXT), this::handle);
        log.info("Server listening to http://%s:%s%s", configuration.get(HOST), configuration.get(PORT), configuration.get(CONTEXT));
        server.start();
    }

    @Override
    public void stop() {
        if (server != null) {
            server.stop(0);
        }
    }

    private void handle(HttpExchange exchange) throws IOException {
        Request request = new SunRequest(exchange);
        Response response = router.handle(request);

        String body = response.getBody();
        String encoding = configuration.get(Router.RESPONSE_ENCODING);
        exchange.sendResponseHeaders(response.getCode(), body.getBytes().length);
        Writer out = new OutputStreamWriter(exchange.getResponseBody(), encoding);
        out.write(body);
        out.close();
        log.debug("%s %s -> %s", request.getMethod(), request.getUri(), response.getCode());
    }

}
