package org.fluentness.service.dispatcher;

import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.fluentness.controller.event.JavaScriptEvent;
import org.fluentness.service.authentication.Authentication;
import org.fluentness.service.log.Log;

import java.io.IOException;

public class EventDispatcher extends AbstractDispatcher {

    private final String sendFunction = "function send(eventId) {" +
        "    var xhttp = new XMLHttpRequest();" +
        "    xhttp.onreadystatechange = function () {" +
        "        if (this.readyState == 4 && (this.status >= 200 || this.status < 300)) {" +
        "            console.log(this.responseText);" +
        "        }" +
        "    };" +
        "    xhttp.open('GET', window.location.href + '?eventId=' + eventId , true);" +
        "    xhttp.setRequestHeader('http_x_requested_with', 'true');" +
        "    xhttp.send();" +
        "}";
    private String eventListeners = "";

    public EventDispatcher(Authentication[] authentications, Log log) {
        super(authentications, log);
    }

    public void addEvent(JavaScriptEvent event) {
        eventListeners += String.format(
            "document.getElementById(%d).addEventListener('%s', function() { send('%s'); });",
            event.getId(),
            event.getEventName(),
            event.getEventId()
        );
    }

    @Override
    public String getUrlPattern() {
        return "/javaScript";
    }

    @Override
    protected void dispatch(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setStatus(HttpServletResponse.SC_OK);
        ServletOutputStream out = response.getOutputStream();
        out.print(sendFunction);
        out.print("window.onload = function() {");
        out.print(eventListeners);
        out.print("}");
        response.setContentType("application/javascript");
    }

}
