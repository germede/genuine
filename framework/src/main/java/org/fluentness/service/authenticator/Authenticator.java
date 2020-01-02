package org.fluentness.service.authenticator;

import org.fluentness.service.Service;
import org.fluentness.service.server.SunRequest;

public interface Authenticator extends Service {

    boolean authenticate(SunRequest request);

}
