package org.fluentness.controller.web.template;

public interface WebTemplate {

    default String render() {
        return toString();
    }

}
