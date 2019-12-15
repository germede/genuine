package com.sample.authenticator;

import org.fluentness.authenticator.Authenticator;
import org.fluentness.server.Request;

public class NormalAuthenticator implements Authenticator {

    @Override
    public boolean authenticate(Request request) {
        return false;
    }
}
