package org.fluentness.service.authentication;

import org.fluentness.service.Service;
import org.fluentness.service.server.Request;

public interface Authentication extends Service {

    boolean authenticate(Request request);

}
