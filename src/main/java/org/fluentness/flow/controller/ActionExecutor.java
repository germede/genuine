package org.fluentness.flow.controller;

import org.fluentness.base.networking.HttpRequest;
import org.fluentness.base.networking.HttpResponse;

@FunctionalInterface
public interface ActionExecutor {
    HttpResponse execute(HttpRequest request);
}
