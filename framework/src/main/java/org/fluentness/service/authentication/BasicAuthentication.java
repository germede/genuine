package org.fluentness.service.authentication;

import org.fluentness.service.configuration.Configuration;
import org.fluentness.service.configuration.Setting;
import org.fluentness.service.server.Request;

import java.util.Base64;

public class BasicAuthentication implements Authentication {

    public static final Setting<String> USERNAME = new Setting<>();
    public static final Setting<String> PASSWORD = new Setting<>();

    protected static final String AUTHORIZATION_HEADER = "Authorization";
    protected static final String AUTHENTICATE_HEADER = "WWW-Authenticate";

    private Configuration configuration;

    public BasicAuthentication(Configuration configuration) {
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
