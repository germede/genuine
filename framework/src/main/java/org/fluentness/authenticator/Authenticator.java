package org.fluentness.authenticator;

import org.fluentness.ApplicationComponent;
import org.fluentness.server.Request;

public interface Authenticator extends ApplicationComponent {

    boolean authenticate(Request request);

}
