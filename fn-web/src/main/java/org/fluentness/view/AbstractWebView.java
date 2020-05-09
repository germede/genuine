package org.fluentness.view;

public abstract class AbstractWebView implements View<WebTemplate> {

    public static final ThreadLocal<CharSequence> actionResult = new ThreadLocal<>();

}
