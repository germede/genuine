package org.fluentness.controller;

@FunctionalInterface
public interface ActionExecutor {
    Response execute(Request request);
}
