package org.fluentness.database;

import org.fluentness.Configuration;
import org.fluentness.logging.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Database {

    static SqlQueryResult execute(String query, List<Object> parameters) {
        Connection connection = getConnection();
        SqlQueryResult result = new SqlQueryResult();
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
                    result.resultList = resultSetToResultList(statement.executeQuery());
                    result.resultSize = result.resultList.size();
                } else {
                    result.resultSize = statement.executeUpdate();
                }
            } catch (SQLException e) {
                Logger.error(Database.class, e);
            }
        }
        return result;
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
                Configuration.getString(Configuration.DB_URL_PARAMS);
        String username = Configuration.getString(Configuration.DB_USERNAME);
        String password = Configuration.getString(Configuration.DB_PASSWORD);

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