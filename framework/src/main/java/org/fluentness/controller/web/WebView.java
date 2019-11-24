package org.fluentness.controller.web;

import org.fluentness.controller.View;

@FunctionalInterface
public interface WebView extends View {

    @Override
    String render();

}
