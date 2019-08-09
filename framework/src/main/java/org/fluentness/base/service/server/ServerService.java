package org.fluentness.base.service.server;

import org.fluentness.base.service.server.Server;
import org.fluentness.base.service.server.HttpHandler;

import java.util.Map;

public class ServerService implements Service<Server> {

    private Server server;

    public ServerService(Server server) {
        this.server = server;
    }

    @Override
    public Server getComponent() {
        return server;
    }

    public void start(Map<String, HttpHandler> routing) {
        server.start(routing);
    }

    public void stop() {
        server.stop();
    }
}
