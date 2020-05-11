package org.fluentness.service.authentication;

import org.fluentness.service.WebService;
import org.fluentness.service.server.Request;
import org.fluentness.service.server.Response;

public interface Authentication extends WebService {

    boolean authorize(Request request);

    Response demandCredentials(Request request);
}
