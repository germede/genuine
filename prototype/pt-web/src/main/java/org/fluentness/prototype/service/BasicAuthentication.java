package org.fluentness.prototype.service;

import org.fluentness.service.authentication.AbstractBasicAuthentication;
import org.fluentness.service.persistence.Persistence;

import java.sql.SQLException;

public class BasicAuthentication extends AbstractBasicAuthentication {


    private final Persistence persistence;

    public BasicAuthentication(Persistence persistence) {
        this.persistence = persistence;
    }

    @Override
    protected boolean authorize(String username, String password) {
        try {
            return persistence.getConnectionSource()
                .getReadOnlyConnection("authentication").queryForLong("SELECT * FROM user WHERE username = '" + username + "'") > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
