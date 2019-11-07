package org.fluentness.service.server;

import org.fluentness.service.Service;

public interface ServerService extends Service {

    void start() throws ServerException;

    void stop();
}
