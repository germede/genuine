package org.fluentness.service.authenticator;

import org.fluentness.ApplicationComponent;
import org.fluentness.service.Multiton;
import org.fluentness.service.server.Request;

@Multiton
public interface Authenticator extends ApplicationComponent {

    boolean authenticate(Request request);

}
