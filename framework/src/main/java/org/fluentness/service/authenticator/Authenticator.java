package org.fluentness.service.authenticator;

import org.fluentness.service.Service;
import org.fluentness.service.dispatcher.Request;
import org.fluentness.service.dispatcher.Response;

public interface Authenticator extends Service {

    Response authenticate(Request request);

}
