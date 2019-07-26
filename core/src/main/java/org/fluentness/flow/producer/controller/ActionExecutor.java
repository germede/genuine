package org.fluentness.flow.producer.controller;

import org.fluentness.base.service.server.HttpRequest;
import org.fluentness.base.service.server.HttpResponse;

@FunctionalInterface
public interface ActionExecutor {
    HttpResponse execute(HttpRequest request);
}
