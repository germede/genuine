package org.fluentness.prototype.service;

import com.j256.ormlite.support.DatabaseConnection;
import jakarta.servlet.http.HttpServletRequest;
import org.fluentness.service.authenticator.BaseAuthenticator;
import org.fluentness.service.log.Log;
import org.fluentness.service.persistence.Persistence;

import java.sql.SQLException;

public class Authenticator extends BaseAuthenticator {


    private final Log log;
    private final DatabaseConnection connection;

    public Authenticator(Log log, Persistence persistence) throws SQLException {
        this.log = log;
        connection = persistence.getConnectionSource().getReadOnlyConnection("authentication");
    }

    @Override
    protected boolean authorize(HttpServletRequest request, String username, String password) {
        boolean authorize = false;
        try {
            authorize = connection.queryForLong(
                "SELECT * FROM user WHERE username = '" + username + "' AND password = '" + password + "'"
            ) > 0;
        } catch (SQLException e) {
            log.error(e);
        }
        if (authorize) request.getSession().setAttribute("username", username);
        return authorize;
    }

}
