package org.fluentness.service.authentication;

import org.fluentness.service.server.Request;
import org.fluentness.service.server.Response;

public class DefaultAuthentication implements Authentication {

    @Override
    public boolean authorize(Request request) {
        return true;
    }

    @Override
    public Response demandCredentials(Request request) {
        return null;
    }

}
