package org.fluentness.database;

import org.fluentness.Fluentness;
import org.fluentness.logging.Logger;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

final class Database {

    static SqlResult execute(String query, List<Object> parameters) {
        Connection connection = getConnection();
        SqlResult result = new SqlResult();
        if (connection != null) {
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                if (parameters == null) {
                    parameters = new ArrayList<>();
                }
                int i = 0;
                for (Object parameter : parameters) {
                    statement.setObject(++i, parameter);
                }
                Logger.debug(Database.class, statement.toString().replaceAll(".+: ",""));
                if (query.startsWith("SELECT")) {
                    result.set = statement.executeQuery();
                } else {
                    result.size = statement.executeUpdate();
                }
            } catch (SQLException e) {
                Logger.error(Database.class, e);
            }
        }
        return result;
    }

    private static Connection getConnection() {

        String url = "jdbc:" +
                Fluentness.Configuration.getString(Fluentness.Configuration.DB_DRIVER) + "://" +
                Fluentness.Configuration.getString(Fluentness.Configuration.DB_HOSTNAME) + ":" +
                Fluentness.Configuration.getInt(Fluentness.Configuration.DB_PORT) + "/" +
                Fluentness.Configuration.getString(Fluentness.Configuration.DB_NAME) +
                Fluentness.Configuration.getString(Fluentness.Configuration.DB_PARAMS);
        String username = Fluentness.Configuration.getString(Fluentness.Configuration.DB_USERNAME);
        String password = Fluentness.Configuration.getString(Fluentness.Configuration.DB_PASSWORD);

        try {
            return DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            Logger.error(Database.class, e);
        }
        return null;
    }

    private Database () {

    }
}