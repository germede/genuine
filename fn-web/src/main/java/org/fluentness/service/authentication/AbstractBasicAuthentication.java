package org.fluentness.service.authentication;

import org.fluentness.service.server.Request;
import org.fluentness.service.server.RequestHeader;
import org.fluentness.service.server.Response;
import org.fluentness.service.server.ResponseHeader;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

import static org.fluentness.service.server.ResponseStatusCode.UNAUTHORIZED;

public abstract class AbstractBasicAuthentication implements Authentication {

    private static final String PREFIX = "Basic";

    @Override
    public boolean authorize(Request request) {
        String authorizationHeader = request.getHeaders().get(RequestHeader.AUTHORIZATION);
        String prefix = PREFIX;
        if (authorizationHeader != null && authorizationHeader.startsWith(prefix)) {
            String[] credentials = new String(
                Base64.getDecoder().decode(authorizationHeader.substring(5).trim()),
                StandardCharsets.UTF_8
            ).split(":", 2);
            return authorize(credentials[0], credentials[1]);
        }
        return false;
    }

    @Override
    public Response demandCredentials(Request request) {
        Response response = request.makeResponse(UNAUTHORIZED, "", "");
        response.addHeader(ResponseHeader.WWW_AUTHENTICATE, PREFIX);
        return response;
    }

    protected abstract boolean authorize(String username, String password);

}
