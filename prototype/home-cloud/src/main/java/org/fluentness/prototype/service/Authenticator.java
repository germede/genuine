package org.fluentness.prototype.service;

import com.j256.ormlite.support.DatabaseConnection;
import jakarta.servlet.http.HttpServletRequest;
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
    protected boolean authorize(HttpServletRequest request, String username, String password) {
        boolean authorize = false;
        try (DatabaseConnection connection = persistence.getConnectionSource().getReadOnlyConnection("authentication")) {
            authorize = connection.queryForLong(
                "SELECT * FROM user WHERE username = '" + username + "' AND password = '" + password + "'"
            ) > 0;
        } catch (SQLException | IOException e) {
            log.error(e);
        }
        if (authorize) request.getSession().setAttribute("username", username);
        return authorize;
    }

}
