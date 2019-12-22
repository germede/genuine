package org.fluentness.service.authenticator;

import org.fluentness.ApplicationComponent;
import org.fluentness.service.server.Request;

public interface Authenticator extends ApplicationComponent {

    boolean authenticate(Request request);

}
