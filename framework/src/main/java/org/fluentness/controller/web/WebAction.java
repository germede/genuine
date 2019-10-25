package org.fluentness.controller.web;

import org.fluentness.service.server.HttpMethod;

public @interface WebAction {
    String path();
    HttpMethod method() default HttpMethod.GET;
}
