package org.fluentness.prototype.service;

import com.j256.ormlite.support.DatabaseConnection;
import org.fluentness.service.authenticator.BaseAuthenticator;
import org.fluentness.service.log.Log;
import org.fluentness.service.persistence.Persistence;

import java.io.IOException;
import java.sql.SQLException;

public class Authenticator extends BaseAuthenticator {


    private final Log log;
    private final Persistence persistence;

    public Authenticator(Log log, Persistence persistence) {
        this.log = log;
        this.persistence = persistence;
    }

    @Override
    protected boolean authorize(String username, String password) {
        boolean result = false;
        try (DatabaseConnection connection = persistence.getConnectionSource().getReadOnlyConnection("authentication")){
            result = connection.queryForLong("SELECT * FROM user WHERE username = '" + username + "'") > 0;
        } catch (SQLException | IOException e) {
            log.error(e);
        }
        return result;
    }
}
