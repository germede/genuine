package org.fluentness.database;

import org.fluentness.FnConf;
import org.fluentness.logging.Log;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Database {

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
                Log.debug(Database.class, statement.toString().replaceAll(".+: ",""));
                if (query.startsWith("SELECT")) {
                    result.resultList = resultSetToResultList(statement.executeQuery());
                    result.resultSize = result.resultList.size();
                } else {
                    result.resultSize = statement.executeUpdate();
                }
            } catch (SQLException e) {
                Log.error(Database.class, e);
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
                FnConf.getString(FnConf.DB_DRIVER) + "://" +
                FnConf.getString(FnConf.DB_HOSTNAME) + ":" +
                FnConf.getInt(FnConf.DB_PORT) + "/" +
                FnConf.getString(FnConf.DB_NAME) +
                FnConf.getString(FnConf.DB_URL_PARAMS);
        String username = FnConf.getString(FnConf.DB_USERNAME);
        String password = FnConf.getString(FnConf.DB_PASSWORD);

        try {
            return DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            Log.error(Database.class, e);
        }
        return null;
    }

    private Database () {

    }
}