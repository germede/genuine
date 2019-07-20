package org.fluentness.flow.controller;

import org.fluentness.base.server.HttpRequest;
import org.fluentness.base.server.HttpResponse;

@FunctionalInterface
public interface ActionExecutor {
    HttpResponse execute(HttpRequest request);
}
