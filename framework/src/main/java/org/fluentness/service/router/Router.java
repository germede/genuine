package org.fluentness.service.router;

import org.fluentness.service.Service;

import java.util.Map;

public interface Router extends Service {

    Map<String, HttpHandler> getRoutingMap();
}
