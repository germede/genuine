package org.fluentness.view.web;

import org.fluentness.view.View;

@FunctionalInterface
public interface WebView extends View {

    @Override
    String render();

}
