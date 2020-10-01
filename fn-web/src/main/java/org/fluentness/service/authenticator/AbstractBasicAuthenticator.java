package org.fluentness.service.authenticator;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.fluentness.service.server.*;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

public abstract class AbstractBasicAuthenticator implements Authenticator {

    @Override
    public boolean authorize(HttpServletRequest request, HttpServletResponse response) {
        String authorizationHeader = request.getHeader(RequestHeader.AUTHORIZATION);
        if (authorizationHeader != null && authorizationHeader.startsWith("Basic ")) {
            String[] credentials = new String(
                Base64.getDecoder().decode(authorizationHeader.substring(5).trim()),
                StandardCharsets.UTF_8
            ).split(":", 2);
            if (authorize(credentials[0], credentials[1])) {
                return true;
            }
        }
        response.addHeader(ResponseHeader.WWW_AUTHENTICATE, "Basic ");
        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        return false;
    }

    protected abstract boolean authorize(String username, String password);


}
