package org.fluentness.flow.web;

import org.fluentness.base.server.HttpMethod;

public @interface WebAction {
    String path();
    HttpMethod method() default HttpMethod.GET;
}
