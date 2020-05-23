package org.fluentness.service.dispatcher;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.fluentness.service.authentication.Authentication;
import org.fluentness.service.log.Log;
import org.fluentness.view.action.Clickable;

import java.io.IOException;

public class JavaScriptDispatcher extends AbstractDispatcher {

    private static String javaScript = "";

    public static void registerClickAction(int id, Clickable.OnClickAction onClickAction) {
        javaScript += "console.log(" + id + ");";
    }

    public JavaScriptDispatcher(Authentication[] authentications, Log log) {
        super(authentications, log);
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
