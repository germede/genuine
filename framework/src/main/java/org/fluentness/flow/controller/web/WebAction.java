package org.fluentness.flow.controller.web;

import org.fluentness.base.service.server.HttpMethod;

public @interface WebAction {
    String path();
    HttpMethod method();
}
