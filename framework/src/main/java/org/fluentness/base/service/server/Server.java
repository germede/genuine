package org.fluentness.base.service.server;

import org.fluentness.base.common.annotation.DefinitionPriority;
import org.fluentness.base.service.Service;

import java.util.Map;

@DefinitionPriority(100)
public interface Server extends Service {

    void start(Map<String, HttpHandler> routing);

    void stop();
}
