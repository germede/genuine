package org.fluentness.prototype.service;

import jakarta.servlet.http.HttpServletRequest;
import org.fluentness.prototype.model.User;
import org.fluentness.service.authenticator.BaseAuthenticator;
import org.fluentness.service.persistence.Persistence;

public class Authenticator extends BaseAuthenticator {

    private final Persistence persistence;

    public Authenticator(Persistence persistence) {
        this.persistence = persistence;
    }

    @Override
    protected boolean authorize(HttpServletRequest request, String username, String password) {
        boolean authorize = persistence.retrieve(User.class,
            "username = '" + username + "'",
            "password = '" + password + "'"
        ).size() > 0;
        if (authorize) request.getSession().setAttribute("username", username);
        return authorize;
    }

}
