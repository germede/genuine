package org.fluentness.service.authenticator;

import org.fluentness.Fluentness;
import org.fluentness.service.configurator.Configurator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Base64;

import static org.fluentness.service.configurator.Configurator.authentication_password;
import static org.fluentness.service.configurator.Configurator.authentication_username;

public class BasicAuthenticator implements Authenticator {

    private static final String AUTHORIZATION_HEADER = "Authorization";
    private static final String AUTHENTICATE_HEADER = "WWW-Authenticate";

    private Configurator configurator;

    public BasicAuthenticator(Configurator configurator) {
        this.configurator = configurator;
    }

    @Override
    public boolean authenticate(HttpServletRequest request, HttpServletResponse response) {
        String requestHeader = request.getHeader(AUTHORIZATION_HEADER);

        if (requestHeader != null &&
            requestHeader.startsWith("Basic ") &&
            configurator.has(authentication_username) &&
            configurator.has(authentication_password)) {

            String own = configurator.get(authentication_username) + ":" + configurator.get(authentication_password);

            if (Base64.getEncoder().encodeToString(own.getBytes()).equals(requestHeader.split(" ")[1])) {
                return true;
            }
        }

        response.setHeader(AUTHENTICATE_HEADER, "Basic realm=\"" + Fluentness.getApplication().getName() + "\"");
        response.setStatus(401);
        return false;
    }

}
