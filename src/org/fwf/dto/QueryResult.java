package org.fwf.dto;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class QueryResult {

    public int code;
    public List<Map<String, Object>> resultMap;

    void setQueryResult(ResultSet resultSet) throws SQLException {
        resultMap = new ArrayList<>();
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
    }
}