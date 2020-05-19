package org.fluentness.service.server;

import fi.iki.elonen.NanoHTTPD;
import org.fluentness.service.configuration.Configuration;
import org.fluentness.service.log.Log;
import org.fluentness.service.router.Router;

import java.io.IOException;

public class ServerImpl extends NanoHTTPD implements Server {


    private final Configuration configuration;
    private final Log log;
    private final Router router;

    public ServerImpl(Configuration configuration, Log log, Router router) {
        super(configuration.get(HOST),configuration.get(PORT));
        this.configuration = configuration;
        this.log = log;
        this.router = router;
    }

    @Override
    public void start() throws IOException {
        start(NanoHTTPD.SOCKET_READ_TIMEOUT, false);
        log.info("Server listening to http://%s:%s%s", configuration.get(HOST), configuration.get(PORT), configuration.get(CONTEXT));
    }

    @Override
    public Response serve(IHTTPSession session) {
        RequestImpl request = new RequestImpl(session);
        org.fluentness.service.server.Response response = router.handle(request);
        log.debug("%s %s -> %s", request.getMethod(), request.getUri(), response.getStatusCode());
        return (ResponseImpl) response;
    }
}
