package org.fluentness.service.server;

import org.fluentness.service.Service;
import org.fluentness.service.configurator.Key;

import static org.fluentness.service.Service.ServiceType;
import static org.fluentness.service.Service.Type.REPLACEABLE;

@ServiceType(REPLACEABLE)
public interface Server extends Service {

    Key<String> server_context = new Key<>();
    Key<Integer> server_port = new Key<>();
    Key<String> server_response_encoding = new Key<>();
    Key<Boolean> server_single_page_mode = new Key<>();

    void start() throws ServingException;

    void stop();
}
