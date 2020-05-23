package org.fluentness.service.dispatcher;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.fluentness.controller.event.JavaScriptEvent;
import org.fluentness.service.authentication.Authentication;
import org.fluentness.service.log.Log;

import java.io.IOException;

public class EventDispatcher extends AbstractDispatcher {

    private String javaScript = "";

    public EventDispatcher(Authentication[] authentications, Log log) {
        super(authentications, log);
    }

    public void addEvent(JavaScriptEvent event) {
        javaScript += "console.log(" + event.getId() + ");";
    }

    @Override
    public String getUrlPattern() {
        return "/javaScript";
    }

    @Override
    protected void dispatch(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setStatus(HttpServletResponse.SC_OK);
        response.getOutputStream().print(javaScript);
        response.setContentType("application/javascript");
    }

}
