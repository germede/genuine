package org.fwf.dba;

import org.fwf.cnf.Configuration;
import org.fwf.log.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Database {

    static QueryResult execute(String query, List<Object> parameters) {
        Connection connection = getConnection();
        QueryResult result = new QueryResult();
        if (connection != null) {
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                if (parameters == null) {
                    parameters = new ArrayList<>();
                }
                int i = 0;
                for (Object parameter : parameters) {
                    statement.setObject(++i, parameter);
                }
                Logger.d(statement.toString());
                if (query.startsWith("SELECT")) {
                    result.resultList = resultSetToResultList(statement.executeQuery());
                    result.resultSize = result.resultList.size();
                } else {
                    result.resultSize = statement.executeUpdate();
                }
            } catch (SQLException e) {
                Logger.e(e, e.getMessage());
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
            Logger.e(e, e.getMessage());
        }
        return null;
    }
}