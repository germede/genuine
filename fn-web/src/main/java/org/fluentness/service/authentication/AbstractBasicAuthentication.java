package org.fluentness.service.authentication;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.fluentness.service.server.*;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

public abstract class AbstractBasicAuthentication implements Authentication {

    @Override
    public boolean authorize(HttpServletRequest request) {
        String authorizationHeader = request.getHeader(RequestHeader.AUTHORIZATION);
        if (authorizationHeader != null && authorizationHeader.startsWith("Basic ")) {
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
    public void demandCredentials(HttpServletResponse response) {
        response.addHeader(ResponseHeader.WWW_AUTHENTICATE, "Basic ");
    }

    protected abstract boolean authorize(String username, String password);


}
