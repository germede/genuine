package com.sample.service;

import org.fluentness.service.authenticator.Authenticator;
import org.fluentness.service.server.Request;

public class NormalAuthenticator implements Authenticator {
    @Override
    public boolean authenticate(Request request) {
        return false;
    }
}
