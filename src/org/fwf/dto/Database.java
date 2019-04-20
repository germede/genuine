package org.fwf.dto;

import org.fwf.cnf.Configuration;
import org.fwf.log.Log;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

class Database {

    static QueryResult execute(String query, List<Object> parameters) {
        Connection connection = getConnection();
        QueryResult result = new QueryResult();
        if (connection != null) {
            try (PreparedStatement ps = connection.prepareStatement(query)) {
                if (parameters == null) {
                    parameters = new ArrayList<>();
                }
                int i = 0;
                for (Object parameter : parameters) {
                    ps.setObject(++i, parameter);
                }
                if (query.startsWith("SELECT")) {
                    result.setQueryResult(ps.executeQuery());
                } else {
                    result.code = ps.executeUpdate();
                }
            } catch (SQLException e) {
                Log.e(e.getMessage(), e);
            }
        }
        return result;
    }

    private static Connection getConnection() {

        String url = "jdbc:" +
                Configuration.get(Configuration.DB_DRIVER) + "://" +
                Configuration.get(Configuration.DB_HOSTNAME) + ":" +
                Configuration.get(Configuration.DB_PORT) + "/" +
                Configuration.get(Configuration.DB_NAME) +
                Configuration.get(Configuration.DB_URLPARAMS);
        String username = Configuration.get(Configuration.DB_USERNAME);
        String password = Configuration.get(Configuration.DB_PASSWORD);

        try {
            return DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            Log.e(e.getMessage(), e);
        }
        return null;
    }
}