package org.fluentness.service.authenticator;

import org.fluentness.Fluentness;
import org.fluentness.service.configurator.Configurator;
import org.fluentness.service.configurator.Key;
import org.fluentness.service.dispatcher.Request;
import org.fluentness.service.dispatcher.Response;

import java.util.Base64;

public class BasicAuthenticator implements Authenticator {

    public static final Key<String> basic_authenticator_username = new Key<>();
    public static final Key<String> basic_authenticator_password = new Key<>();

    private static final String AUTHORIZATION_HEADER = "Authorization";
    private static final String AUTHENTICATE_HEADER = "WWW-Authenticate";

    private Configurator configurator;

    public BasicAuthenticator(Configurator configurator) {
        this.configurator = configurator;
    }

    @Override
    public Response authenticate(Request request) {
        String requestHeader = request.getHeader(AUTHORIZATION_HEADER);

        if (requestHeader != null &&
            requestHeader.startsWith("Basic ") &&
            configurator.has(basic_authenticator_username) &&
            configurator.has(basic_authenticator_password)) {

            String own = configurator.get(basic_authenticator_username) + ":" + configurator.get(basic_authenticator_password);

            if (Base64.getEncoder().encodeToString(own.getBytes()).equals(requestHeader.split(" ")[1])) {
                return null;
            }
        }
        return response -> {
            response.setHeader(AUTHENTICATE_HEADER, "Basic realm=\"" + Fluentness.getApplication().getName() + "\"");
            response.setStatus(401);
        };
    }

}
