package org.fluentness.controller.web;

import org.fluentness.controller.View;

public interface WebView extends View<WebTemplate> {

    ThreadLocal<CharSequence> actionResult = new ThreadLocal<>();

}
