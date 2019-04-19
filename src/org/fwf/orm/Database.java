package org.fwf.orm;

import org.fwf.cnf.Configuration;
import org.fwf.log.Log;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Database {

    private static Map<String, String> drivers;

    static {
        drivers = new HashMap<>();
        drivers.put("mysql", "com.mysql.cj.jdbc.Driver");
        drivers.put("postgresql", "org.postgresql.Driver");
    }

    public static List<Map<String, Object>> executeSelect(String query, List<Object> parameters) {
        Connection connection = getConnection();
        if (connection != null) {
            try (PreparedStatement ps = connection.prepareStatement(query)) {
                int i = 0;
                for (Object parameter : parameters) {
                    ps.setObject(++i, parameter);
                }
                return map(ps.executeQuery());
            } catch (SQLException e) {
                Log.e(e.getMessage(), e);
            }
        }
        return null;
    }

    public static int execute(String query, List<Object> parameters) {
        Connection connection = getConnection();
        if (connection != null) {
            try (PreparedStatement ps = connection.prepareStatement(query)) {
                int i = 0;
                for (Object parameter : parameters) {
                    ps.setObject(++i, parameter);
                }
                return ps.executeUpdate();
            } catch (SQLException e) {
                Log.e(e.getMessage(), e);
            }
        }
        return 0;
    }

    private static List<Map<String, Object>> map(ResultSet rs) throws SQLException {
        List<Map<String, Object>> results = new ArrayList<>();
        ResultSetMetaData meta = rs.getMetaData();
        int numColumns = meta.getColumnCount();
        while (rs.next()) {
            Map<String, Object> row = new HashMap<>();
            for (int i = 1; i <= numColumns; ++i) {
                String name = meta.getColumnName(i);
                Object value = rs.getObject(i);
                row.put(name, value);
            }
            results.add(row);
        }
        return results;
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