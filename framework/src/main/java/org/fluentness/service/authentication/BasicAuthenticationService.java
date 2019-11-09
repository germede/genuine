package org.fluentness.service.authentication;

import org.fluentness.Fluentness;
import org.fluentness.service.configuration.ConfigurationService;
import org.fluentness.service.router.HttpStatusCode;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Base64;

import static org.fluentness.service.configuration.ConfigurationService.authentication_password;
import static org.fluentness.service.configuration.ConfigurationService.authentication_username;

public class BasicAuthenticationService implements AuthenticationService {

    private static final String AUTHORIZATION_HEADER = "Authorization";
    private static final String AUTHENTICATE_HEADER = "WWW-Authenticate";

    private ConfigurationService configurationService;

    public BasicAuthenticationService(ConfigurationService configurationService) {
        this.configurationService = configurationService;
    }

    @Override
    public boolean authenticate(HttpServletRequest request, HttpServletResponse response) {
        String requestHeader = request.getHeader(AUTHORIZATION_HEADER);

        if (requestHeader != null &&
            requestHeader.startsWith("Basic ") &&
            configurationService.has(authentication_username) &&
            configurationService.has(authentication_password)) {

            String own = configurationService.get(authentication_username) + ":" + configurationService.get(authentication_password);

            if (Base64.getEncoder().encodeToString(own.getBytes()).equals(requestHeader.split(" ")[1])) {
                return true;
            }
        }

        response.setHeader(AUTHENTICATE_HEADER, "Basic realm=\"" + Fluentness.getApplication().getName() + "\"");
        response.setStatus(HttpStatusCode.UNAUTHORIZED.toInt());
        return false;
    }

}
