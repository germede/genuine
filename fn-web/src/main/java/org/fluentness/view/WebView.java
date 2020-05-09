package org.fluentness.view;

public interface WebView extends View<WebTemplate> {

    ThreadLocal<CharSequence> actionResult = new ThreadLocal<>();

}
