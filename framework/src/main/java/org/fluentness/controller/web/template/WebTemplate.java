package org.fluentness.controller.web.template;

public interface WebTemplate extends CharSequence {

    default String render() {
        return toString();
    }

}
