package org.fluentness.service.authentication;

import org.fluentness.service.Service;
import org.fluentness.service.server.Request;
import org.fluentness.service.server.Response;

public interface Authentication extends Service {

    boolean authorize(Request request);

    Response demandCredentials(Request request);
}
