package org.fluentness.authenticator;

import org.fluentness.configuration.Configuration;
import org.fluentness.configuration.Key;
import org.fluentness.server.Request;

import java.util.Base64;

public class BasicAuthenticator implements Authenticator {

    public static final Key<String> USERNAME = new Key<>();
    public static final Key<String> PASSWORD = new Key<>();

    protected static final String AUTHORIZATION_HEADER = "Authorization";
    protected static final String AUTHENTICATE_HEADER = "WWW-Authenticate";

    private Configuration configuration;

    public BasicAuthenticator(Configuration configuration) {
        this.configuration = configuration;
    }

    @Override
    public boolean authenticate(Request request) {
        String requestHeader = request.getHeaders().get(AUTHORIZATION_HEADER).get(0);

        if (requestHeader != null &&
            requestHeader.startsWith("Basic ") &&
            configuration.has(USERNAME) &&
            configuration.has(PASSWORD)) {

            String own = configuration.get(USERNAME) + ":" + configuration.get(PASSWORD);

            if (Base64.getEncoder().encodeToString(own.getBytes()).equals(requestHeader.split(" ")[1])) {
                return true;
            }
        }
        return false;
    }

}
