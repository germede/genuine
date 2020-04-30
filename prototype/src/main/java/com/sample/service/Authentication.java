package com.sample.service;

import org.fluentness.service.authentication.AbstractAuthentication;

public class Authentication extends AbstractAuthentication {

    @Override
    protected boolean authorize(String username, String password) {
        return true;
    }
}
