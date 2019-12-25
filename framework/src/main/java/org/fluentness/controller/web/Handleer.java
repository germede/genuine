package org.fluentness.controller.web;

import org.fluentness.service.server.Request;

@FunctionalInterface
public interface Handleer {

    boolean authenticate(Request request);

}
