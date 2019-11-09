package org.fluentness.service.caching;

import org.fluentness.controller.web.WebView;

import java.lang.reflect.InvocationTargetException;

@FunctionalInterface
public interface WebViewProvider {
    WebView provide() throws InvocationTargetException, IllegalAccessException;
}
