package org.fluentness.service.dispatcher;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.fluentness.service.authentication.Authentication;
import org.fluentness.service.log.Log;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

public class StaticDispatcher extends AbstractDispatcher {

    public StaticDispatcher(Authentication[] authentications, Log log) {
        super(authentications, log);
    }

    @Override
    public String getUrlPattern() {
        return "/static/*";
    }

    @Override
    protected void dispatch(HttpServletRequest request, HttpServletResponse response) throws Throwable {
        String filePath = request.getRequestURI().replace("/static/", "");
        InputStream resourceAsStream = getClass().getClassLoader().getResourceAsStream(filePath);
        if (resourceAsStream != null) {
            BufferedReader reader = new BufferedReader(new InputStreamReader(resourceAsStream, StandardCharsets.UTF_8));
            StringBuilder result = new StringBuilder();
            String line;
            while (true) {
                if ((line = reader.readLine()) == null) break;
                result.append(line);
            }
            response.setStatus(HttpServletResponse.SC_OK);
            response.getOutputStream().print(result.toString());
            response.setContentType(
                filePath.startsWith("css") ? "text/css" :
                    filePath.startsWith("js") ? "application/javascript" :
                        "image/png"
            );
        } else {
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
        }
        super.service(request, response);
    }

}
