package org.fluentness.service.cache;

import org.fluentness.controller.web.WebView;

import java.lang.reflect.InvocationTargetException;

@FunctionalInterface
public interface WebViewProvider {
    WebView provide() throws InvocationTargetException, IllegalAccessException;
}
