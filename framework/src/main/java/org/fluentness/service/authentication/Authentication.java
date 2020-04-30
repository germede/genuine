package org.fluentness.service.authentication;

import org.fluentness.service.Service;
import org.fluentness.service.server.Request;
import org.fluentness.service.server.Response;

public interface Authentication extends Service {

    Response handle(Request request, ResponseLambda success);

    @FunctionalInterface
    interface ResponseLambda {
        Response response();
    }
}
