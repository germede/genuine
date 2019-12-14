package org.fluentness.authenticator;

import org.fluentness.server.Request;

public interface Authenticator {

    boolean authenticate(Request request);

}
