package org.fluentness.service.authentication;

import org.fluentness.service.server.Request;
import org.fluentness.service.server.Response;

public class DefaultAuthentication implements Authentication {

    @Override
    public Response handle(Request request, ResponseLambda success) {
        return success.response();
    }

}
