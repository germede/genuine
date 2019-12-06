package com.sample.service;

import org.fluentness.service.authenticator.Authenticator;
import org.fluentness.service.dispatcher.Request;
import org.fluentness.service.dispatcher.Response;

public class NormalAuthenticator implements Authenticator {
    @Override
    public Response authenticate(Request request) {
        return null;
    }
}
