package org.fluentness.service.authentication;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class AuthenticationImpl implements Authentication {

    @Override
    public boolean authorize(HttpServletRequest request) {
        return true;
    }

    @Override
    public void demandCredentials(HttpServletResponse response) {
    }
}
