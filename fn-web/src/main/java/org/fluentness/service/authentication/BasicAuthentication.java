package org.fluentness.service.authentication;

import org.fluentness.service.server.*;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

public abstract class BasicAuthentication implements Authentication {

    @Override
    public boolean authorize(Request request) {
        String authorizationHeader = request.getHeader(RequestHeader.AUTHORIZATION);
        String prefix = AuthenticationType.BASIC.toString();
        if (authorizationHeader != null && authorizationHeader.startsWith(prefix)) {
            String[] credentials = new String(
                Base64.getDecoder().decode(
                    authorizationHeader.substring(5).trim()
                ),
                StandardCharsets.UTF_8
            ).split(":", 2);
            return authorize(credentials[0], credentials[1]);
        }
        return false;
    }

    @Override
    public Response demandCredentials(Request request) {
        return request.makeResponse(ResponseStatusCode.UNAUTHORIZED).addHeader(
            ResponseHeader.WWW_AUTHENTICATE, AuthenticationType.BASIC.toString()
        );
    }

    protected abstract boolean authorize(String username, String password);


}
