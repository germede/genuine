package org.fluentness.database;

import org.fluentness.configuration.Configuration;
import org.fluentness.logging.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

final class Database {

    public static List<Map<String, Object>> read(String query, List<Object> parameters) {
        List<Map<String, Object>> resultList = new ArrayList<>();
        Connection connection = getConnection();
        if (connection != null) {
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                if (parameters != null) {
                    int i = 0;
                    for (Object parameter : parameters) {
                        statement.setObject(++i, parameter);
                    }
                }
                Logger.debug(Database.class, statement.toString().replaceAll(".+: ", ""));
                resultList = resultSetToResultList(statement.executeQuery());
            } catch (SQLException e) {
                Logger.error(Database.class, e);
            }
        }
        return resultList;
    }

    public static int write(String query, List<Object> parameters) {
        Connection connection = getConnection();
        if (connection != null) {
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                if (parameters != null) {
                    int i = 0;
                    for (Object parameter : parameters) {
                        statement.setObject(++i, parameter);
                    }
                }
                Logger.debug(Database.class, statement.toString().replaceAll(".+: ", ""));
                return statement.executeUpdate();
            } catch (SQLException e) {
                Logger.error(Database.class, e);
            }
        }
        return 0;
    }

    private static List<Map<String, Object>> resultSetToResultList(ResultSet resultSet) throws SQLException {

        List<Map<String, Object>> resultMap = new ArrayList<>();
        ResultSetMetaData meta = resultSet.getMetaData();
        int numColumns = meta.getColumnCount();
        while (resultSet.next()) {
            Map<String, Object> row = new HashMap<>();
            for (int i = 1; i <= numColumns; ++i) {
                String name = meta.getColumnName(i);
                Object value = resultSet.getObject(i);
                row.put(name, value);
            }
            resultMap.add(row);
        }
        return resultMap;
    }

    private static Connection getConnection() {

        String url = "jdbc:" +
                Configuration.getString(Configuration.DB_DRIVER) + "://" +
                Configuration.getString(Configuration.DB_HOSTNAME) + ":" +
                Configuration.getInt(Configuration.DB_PORT) + "/" +
                Configuration.getString(Configuration.DB_NAME) +
                Configuration.getString(Configuration.DB_PARAMS);
        String username = Configuration.getString(Configuration.DB_USERNAME);
        String password = Configuration.getString(Configuration.DB_PASSWORD);

        try {
            return DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            Logger.error(Database.class, e);
        }
        return null;
    }

    private Database() {

    }
}