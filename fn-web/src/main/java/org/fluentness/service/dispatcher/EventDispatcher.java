package org.fluentness.service.dispatcher;

import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.fluentness.controller.view.JavaScriptEvent;
import org.fluentness.service.authentication.Authentication;
import org.fluentness.service.log.Log;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class EventDispatcher extends AbstractDispatcher {

    private String javaScriptCommands;
    private String javaScriptCommons;
    private String javaScriptEvents;

    public EventDispatcher(Authentication[] authentications, Log log) throws URISyntaxException, IOException {
        super(authentications, log);
        javaScriptCommands = new String(Files.readAllBytes(Paths.get(getClass().getResource("/js/javaScript-commands.js").toURI())));
        javaScriptCommons = new String(Files.readAllBytes(Paths.get(getClass().getResource("/js/javaScript-commons.js").toURI())));
        javaScriptEvents = "";
    }

    public void addEventListener(JavaScriptEvent event) {
        if (event.getId().equals("-1null")) {
            // onpageload ajax event, which is always executed)
            javaScriptEvents += "    send('-1null');";
            return;
        }
        javaScriptEvents += String.format(
            "    getElementByXpath('%s').addEventListener('%s', function() { send('%s'); });\n",
            event.getComponentXpath(),
            event.getEventType(),
            event.getId()
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
        out.print(javaScriptCommands);
        out.print("window.onload = function() {\n");
        out.print(javaScriptCommons);
        out.print(javaScriptEvents);
        out.print("}\n");
        response.setContentType("application/javascript");
    }

}
