package org.fluentness.service.dispatcher;

import org.fluentness.controller.AbstractWebController;
import org.fluentness.service.configuration.Setting;

import java.lang.reflect.Method;

public interface Dispatcher extends jakarta.servlet.Servlet {

    Setting<String> RESPONSE_ENCODING = new Setting<>("UTF-8");
    Setting<Boolean> SINGLE_PAGE_MODE = new Setting<>(true);
    Setting<String> AJAX_HANDLER = new Setting<>("<script src=\"/resources/js/ajax-handler.js\"></script>");

    String getUrlPattern();

    void addRoute(String method, String path, Method action, AbstractWebController controller);
}
