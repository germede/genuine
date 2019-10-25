package org.fluentness.base.service;

public interface Service {

    default String translate(String key) {
        return "";
    }

}
