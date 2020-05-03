package org.fluentness.controller;

public interface WebView extends View<WebTemplate> {

    ThreadLocal<CharSequence> actionResult = new ThreadLocal<>();

}
