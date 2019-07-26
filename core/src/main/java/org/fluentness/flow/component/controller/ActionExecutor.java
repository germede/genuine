package org.fluentness.flow.component.controller;

import org.fluentness.base.service.server.HttpRequest;
import org.fluentness.base.service.server.HttpResponse;

@FunctionalInterface
public interface ActionExecutor {
    HttpResponse execute(HttpRequest request);
}
