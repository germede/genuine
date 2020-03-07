package org.fluentness.service.authenticator;

import org.fluentness.service.Service;
import org.fluentness.service.server.Request;

public interface Authenticator extends Service {

    boolean authenticate(Request request);

}
