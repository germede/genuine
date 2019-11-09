package org.fluentness.service.serving;

import org.fluentness.service.Service;

public interface ServingService extends Service {

    void start() throws ServingException;

    void stop();
}
