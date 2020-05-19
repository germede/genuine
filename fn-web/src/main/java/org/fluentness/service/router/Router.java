package org.fluentness.service.router;

import org.fluentness.service.Service;
import org.fluentness.service.configuration.Setting;
import org.fluentness.service.server.Request;
import org.fluentness.service.server.Response;

import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

public interface Router extends Service {

    Setting<String> RESPONSE_ENCODING = new Setting<>("UTF-8");
    Setting<Boolean> SINGLE_PAGE_MODE = new Setting<>(true);
    Setting<String> AJAX_HANDLER = new Setting<>("<script src=\"/resources/js/ajax-handler.js\"></script>");

    Response handle(Request request);

    default Object[] prepareArgs(Method action, Request request) {
        Parameter[] parameters = action.getParameters();
        Object[] result = new Object[parameters.length];
        for (int i = 0; i < parameters.length; i++) {
            Parameter parameter = parameters[i];
            result[i] = request.getParameter(parameter.getType(), parameter.getName());
        }
        return result;
    }

}
