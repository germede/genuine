package org.fluentness.service.dispatcher;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.fluentness.service.authenticator.Authenticator;
import org.fluentness.service.configuration.Configuration;
import org.fluentness.service.configuration.Setting;
import org.fluentness.service.log.Log;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

public class ResourceDispatcher extends BaseDispatcher {

    private static final String RESOURCES_FOLDER = "/resources/";

    public static final Setting<Boolean> INLINE_RESOURCES = new Setting<>(true);
    private final boolean inlineResources;

    public ResourceDispatcher(Authenticator authenticator, Log log, Configuration configuration) {
        super(authenticator, log);
        inlineResources = configuration.get(INLINE_RESOURCES);
    }

    @Override
    public String getUrlPattern() {
        return RESOURCES_FOLDER + "*";
    }

    @Override
    protected void dispatch(HttpServletRequest request, HttpServletResponse response) throws Throwable {
        String filePath = request.getRequestURI().replace(RESOURCES_FOLDER, "");
        InputStream resourceAsStream = getClass().getClassLoader().getResourceAsStream(filePath);
        if (resourceAsStream != null) {
            BufferedReader reader = new BufferedReader(new InputStreamReader(resourceAsStream, StandardCharsets.UTF_8));
            StringBuilder result = new StringBuilder();
            String line;
            while (true) {
                if ((line = reader.readLine()) == null) break;
                result.append(line);
                if (!inlineResources) result.append("\n");
            }
            response.setCharacterEncoding("UTF-8");
            response.setStatus(HttpServletResponse.SC_OK);
            response.getWriter().print(result.toString());
            response.setContentType(
                filePath.startsWith("css") ? "text/css" :
                    filePath.startsWith("js") ? "application/javascript" :
                        "image/png"
            );
        } else {
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
        }
    }

}
