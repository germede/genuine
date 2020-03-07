package org.fluentness.service.authenticator;

import org.fluentness.service.configurator.Configurator;
import org.fluentness.service.configurator.Setting;
import org.fluentness.service.server.SunRequest;

import java.util.Base64;

public class BasicAuthenticator implements Authenticator {

    public static final Setting<String> USERNAME = new Setting<>();
    public static final Setting<String> PASSWORD = new Setting<>();

    protected static final String AUTHORIZATION_HEADER = "Authorization";
    protected static final String AUTHENTICATE_HEADER = "WWW-Authenticate";

    private Configurator configurator;

    public BasicAuthenticator(Configurator configurator) {
        this.configurator = configurator;
    }

    @Override
    public boolean authenticate(SunRequest request) {
        String requestHeader = request.getHeaders().get(AUTHORIZATION_HEADER).get(0);

        if (requestHeader != null &&
            requestHeader.startsWith("Basic ") &&
            configurator.has(USERNAME) &&
            configurator.has(PASSWORD)) {

            String own = configurator.get(USERNAME) + ":" + configurator.get(PASSWORD);

            if (Base64.getEncoder().encodeToString(own.getBytes()).equals(requestHeader.split(" ")[1])) {
                return true;
            }
        }
        return false;
    }

}
