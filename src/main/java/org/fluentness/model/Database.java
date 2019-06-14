package org.fluentness.model;

import org.fluentness.Fluentness;
import org.fluentness.base.logging.Log;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.fluentness.base.constants.Settings.*;

public final class Database {

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
                Log.debug(query);
                resultList = resultSetToResultList(statement.executeQuery());
            } catch (SQLException e) {
                Log.error(e);
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
                Log.debug(query);
                return statement.executeUpdate();
            } catch (SQLException e) {
                Log.error(e);
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
                Fluentness.getString(DB_DRIVER) + "://" +
                Fluentness.getString(DB_HOSTNAME) + ":" +
                Fluentness.getInt(DB_PORT) + "/" +
                Fluentness.getString(DB_NAME) +
                Fluentness.getString(DB_PARAMS);
        String username = Fluentness.getString(DB_USERNAME);
        String password = Fluentness.getString(DB_PASSWORD);

        try {
            return DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            Log.error(e);
        }
        return null;
    }

    private Database() {

    }
}