package org.fluentness.controller.web;

import org.fluentness.service.server.Request;

import java.io.Serializable;

@FunctionalInterface
public interface WebAction extends Serializable {

    Object execute(Request request);

}
